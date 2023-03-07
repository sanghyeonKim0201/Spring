package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.UserRepository
import com.example.mvcboard.dto.UserDTO
import org.springframework.stereotype.Service
import kotlin.reflect.full.memberProperties

@Service
class UserService(private var userRepository: UserRepository){

//    fun saveUser(userDTO: UserDTO) {
//        userRepository.save(userDTO.toEntity())
//    }

    fun signUp(userDTO: UserDTO) : Long?{

        for(user in UserDTO::class.memberProperties){
            if(user.get(userDTO) == ""){
                return null
            }
        }
        //아이디 중복 체크
        var bySign = userRepository.findById(userDTO.id)
        if (bySign.isPresent){
            println("id")
            return null
        }
        //이름 최소 2자리 부터, 특수문자를 제외한 한글, 알파벳 대소문자
        if(userDTO.name.toString().length < 2 || !Regex(".*[ㄱ-힣 | A-z].*").matches(userDTO.name.toString())){
            println("name")
            return null
        }
        //생년월일 체크
        if(!Regex("\\d{4}-\\d{2}-\\d{2}").matches(userDTO.birth.toString())){
            println("birth")
            return null
        }
        //phone 체크
        if(!Regex("\\d{3}-\\d{4}-\\d{4}").matches(userDTO.phone.toString())){
            println("phone")
            return null
        }
        return userRepository.save(userDTO.toEntity()).no
    }

    fun login(userDTO: UserDTO) : UserDTO?{
        var byUserId = userRepository.findByIdAndPw(userDTO.id, userDTO.pw)
        if(byUserId.isPresent){
            return UserDTO().toUserDTO(byUserId.get())
        }else{
            return null
        }
    }
}