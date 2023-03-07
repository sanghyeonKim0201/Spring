package com.example.mvcboard.controller

import com.example.mvcboard.dto.UserDTO
import com.example.mvcboard.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
class UserController(private val userService: UserService) {

    val logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/login")
    fun LoginView() : ModelAndView{
        return ModelAndView("login/login")
    }

    @PostMapping("/login")
    fun Login(@ModelAttribute userDTO: UserDTO): ModelAndView{
        var u = userService.login(userDTO)

        if(u == null){
            return ModelAndView("login/login")
        }
        logger.info("${u.no} 로그인")
        return ModelAndView("board/list")
    }
    @GetMapping("/signup")
    fun SignUpView(): ModelAndView {
        return ModelAndView("signup/signup")
    }

    @PostMapping("/signup")
    fun signup(@ModelAttribute userDTO: UserDTO): ModelAndView {
        if(userService.signUp(userDTO) == null){
            return ModelAndView("signup/signup")
        }
        return ModelAndView("login/login")
    }
}