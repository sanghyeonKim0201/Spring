package com.example.mvcboard.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BoardController {

    @GetMapping("/")
    fun list() : String{
        return "board/list"
    }

    @GetMapping("/post")
    fun post() : String{
        return "board/post"
    }

}