package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.SignUpRepository
import com.example.mvcboard.dto.UserDto
import org.springframework.stereotype.Service

@Service
class SignUpService(private var signUpRepository: SignUpRepository){

    fun saveUser(userDto: UserDto) {
        signUpRepository.save(userDto.toEntity())
    }

}