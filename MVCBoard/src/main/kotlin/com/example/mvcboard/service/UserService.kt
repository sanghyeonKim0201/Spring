package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.UserRepository
import com.example.mvcboard.dto.UserDTO
import org.springframework.stereotype.Service
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDate
import kotlin.reflect.full.memberProperties

@Service
class UserService(private var userRepository: UserRepository){

    fun join(userDTO: UserDTO) : ModelAndView{
        var fail = ModelAndView("users/join")
        var success = ModelAndView("users/login")
//        var success = ModelAndView("redirect:/users/login")
        for(user in UserDTO::class.memberProperties){
            if(user.get(userDTO) == ""){
                fail.addObject("message", "빈칸이 존재합니다")
                return fail
            }
        }
        //아이디 중복 체크
        var bySign = userRepository.findById(userDTO.id)
        if (bySign.isPresent){
            fail.addObject("message", "이미 존재하는 아이디 입니다")
            return fail
        }
        //이름 최소 2자리 부터, 특수문자를 제외한 한글, 알파벳 대소문자
        if(userDTO.name.toString().length < 2 || !Regex(".*[ㄱ-힣 | A-z].*").matches(userDTO.name.toString())){
            fail.addObject("message", "이름은 최소 2자리 부터, 특수문자를 제외한 한글, 알파벳 대소문자로 이루어져 있어야 합니다")
            return fail
        }
        //생년월일 체크
        try {
            var birth : LocalDate = LocalDate.parse(userDTO.birth.toString())
            if(birth.toEpochDay() > LocalDate.now().toEpochDay()){
                fail.addObject("message", "미래의 날짜 입니다")
                return fail
            }
        }catch (e : Exception){
            fail.addObject("message", "생년월일 형식은 yyyy-MM-dd 입니다")
            return fail
        }

        //phone 체크
        if(!Regex("\\d{3}-\\d{4}-\\d{4}").matches(userDTO.phone.toString())){
            fail.addObject("message", "전화번호 형식은 010-0000-0000 입니다")
            return fail
        }

        userRepository.save(userDTO.toEntity())
        return success
    }

    fun login(userDTO: UserDTO) : UserDTO?{
        var byUserId = userRepository.findByIdAndPw(userDTO.id, userDTO.pw)
        if(byUserId.isPresent){
            return UserDTO().toUserDTO(byUserId.get())
        }else{
            return null
        }
    }

    fun loadData(uno: Long) : UserDTO{
        return UserDTO().toUserDTO(userRepository.findByUserNo(uno).get())
    }

    fun userUpdate(uno : Long, userDTO: UserDTO){
        userDTO.userNo = uno
        userRepository.save(userDTO.toEntity())
    }

    fun userDelete(uno: Long){
        println("uno : ${uno}")
        userRepository.deleteById(uno)
    }
}