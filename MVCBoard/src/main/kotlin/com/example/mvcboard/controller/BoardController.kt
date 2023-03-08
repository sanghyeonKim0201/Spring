package com.example.mvcboard.controller

import com.example.mvcboard.dto.BoardDTO
import com.example.mvcboard.service.BoardService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@Tag(name = "BoardController", description = " 등")
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

    @Operation(summary = "글쓰기 API", description = "게시판 insert(글쓰기) API")
    @Parameter(name = "title", description = "title 텍스트박스 이름 ex) <input type=\"text\" name=\"title\">")
    @Parameter(name = "content", description = "content 텍스트박스 이름 ex) <input type=\"text\" name=\"content\">")
    @PostMapping("/post")
    fun write(@ModelAttribute boardDto: BoardDTO): ModelAndView{
        boardService.savePost(boardDto)
        return ModelAndView("board/post")
    }

}