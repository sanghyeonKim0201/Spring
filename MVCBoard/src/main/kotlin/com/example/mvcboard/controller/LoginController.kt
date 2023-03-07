package com.example.mvcboard.controller

import com.example.mvcboard.dto.UserDTO
import com.example.mvcboard.service.UserService
import com.mysql.cj.log.Log
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("/login")
class LoginController(private var userService: UserService) {

    @GetMapping
    fun LoginView() : String{
        return "login/login"
    }

    @PostMapping
    fun Login(@ModelAttribute userDTO: UserDTO): String{
        println(userDTO)
        var u = userService.login(userDTO)

        if(u == null){
            return "login/login"
        }
        println("Login OK")
        return "login/login"
    }

}