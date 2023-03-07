package com.example.mvcboard.controller

import com.example.mvcboard.dto.UserDTO
import com.example.mvcboard.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/signup")
class SignUpController(private var userService: UserService) {

    @GetMapping("")
    fun SignUpView(): ModelAndView {
        return ModelAndView("signup/signup")
    }

    @PostMapping("")
    fun signup(@ModelAttribute userDTO: UserDTO): ModelAndView {
        userService.saveUser(userDTO)
        return ModelAndView("signup/signup")
    }
}