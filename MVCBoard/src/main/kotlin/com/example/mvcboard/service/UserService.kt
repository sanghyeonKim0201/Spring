package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.UserRepository
import com.example.mvcboard.dto.UserDTO
import org.springframework.stereotype.Service

@Service
class UserService(private var userRepository: UserRepository){

    fun saveUser(signUpDto: UserDTO) {
        userRepository.save(signUpDto.toEntity())
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