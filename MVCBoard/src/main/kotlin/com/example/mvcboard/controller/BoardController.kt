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

    @GetMapping("/board")
    fun list(model: Model): ModelAndView {
        var boardList : List<BoardDTO> = boardService.getBoardList()
        model.addAttribute("postList", boardList)
        return ModelAndView("board/list")
    }

    @GetMapping("/post")
    fun post(): ModelAndView {
        return ModelAndView("board/post")
    }

    @PostMapping("/post")
    fun write(@ModelAttribute boardDto: BoardDTO): ModelAndView{
        boardService.savePost(boardDto)
        return ModelAndView("board/post")
    }

}