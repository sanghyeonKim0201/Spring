package com.example.mvcboard.controller

import com.example.mvcboard.dto.BoardDTO
import com.example.mvcboard.service.BoardService

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class BoardController(private var boardService: BoardService) {

    @GetMapping("/")
    fun list(): String {
        return "board/list"
    }

    @GetMapping("/post")
    fun post(): String {
        return "board/post"
    }

    @PostMapping("/post")
    fun write( boardDto: BoardDTO): String{
        boardService.savePost(boardDto)
        return "redirect:/"
    }

}