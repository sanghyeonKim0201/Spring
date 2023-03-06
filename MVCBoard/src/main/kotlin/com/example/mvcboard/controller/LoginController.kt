package com.example.mvcboard.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller

class LoginController {

    @GetMapping("/login")
    fun LoginView() : String{
        return "login/login"
    }

    @PostMapping("/login")
    fun Login(@RequestParam("id")id : String, @RequestParam("pw")pw : String): String{

        return "login/login"
    }

}