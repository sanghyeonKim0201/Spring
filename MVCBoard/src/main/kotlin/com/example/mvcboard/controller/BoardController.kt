package com.example.mvcboard.controller

import com.example.mvcboard.dto.BoardDto
import com.example.mvcboard.service.BoardService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BoardController(@Autowired private var boardService: BoardService) {

    @GetMapping("/")
    fun list(): String {
        return "board/list"
    }

    @GetMapping("/post")
    fun post(): String {
        return "board/post"
    }

    @PostMapping("/post")
    fun write(boardDto: BoardDto): String{
        boardService.savePost(boardDto)
        return "redirect:/"
    }

}