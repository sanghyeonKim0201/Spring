package com.example.mvcboard.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("board")
class BoardController {

    @GetMapping("/")
    fun list(): String {
        println("wasd")
        return "board/list"
    }

    @GetMapping("/post")
    fun post(): String {
        println("post")
        return "board/post"
    }
}