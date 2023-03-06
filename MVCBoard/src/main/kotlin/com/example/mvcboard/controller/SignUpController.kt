package com.example.mvcboard.controller

import com.example.mvcboard.dto.UserDto
import com.example.mvcboard.service.SignUpService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/signup")
class SignUpController(private var signUpService: SignUpService) {

    @GetMapping("")
    fun SignUpView(): ModelAndView {
        return ModelAndView("signup/signup")
    }

    //    @PostMapping("/signup")
//    fun signup(@ModelAttribute userDto: UserDto) : String{
//        println(userDto.u_name)
//        return "signup/signup"
//    }
    @PostMapping("")
    fun signup(@ModelAttribute userDto: UserDto): ModelAndView {
//        println(userDto.u_no)
//        println(userDto.u_name)
//        println(userDto.u_id)
//        println(userDto.u_pw)
//        println(userDto.u_phone)
//        println(userDto.u_birth)
        signUpService.saveUser(userDto)
        return ModelAndView("signup/signup")
    }
}