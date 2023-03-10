package com.example.mvcboard.controller

import com.example.mvcboard.dto.BoardDTO
import com.example.mvcboard.service.BoardService
import org.slf4j.LoggerFactory

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class BoardController(private val boardService: BoardService) {
    private var logger = LoggerFactory.getLogger(BoardController::class.java)

    @GetMapping("/")
    fun list(model: Model): ModelAndView {
        var boardList : List<BoardDTO> = boardService.getBoardList()
        model.addAttribute("postList", boardList)
        return ModelAndView("posts/list")
    }

    @GetMapping("/posts/write")
    fun post(): ModelAndView {
        return ModelAndView("posts/write")
    }

    @PostMapping("/api/posts/write")
    fun write(@ModelAttribute boardDto: BoardDTO): ModelAndView{
        boardService.savePost(boardDto)
        return ModelAndView("posts/write")
    }

}