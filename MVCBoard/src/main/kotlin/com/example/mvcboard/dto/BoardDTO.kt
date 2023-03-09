package com.example.mvcboard.dto

import com.example.mvcboard.domain.entity.Board
import com.example.mvcboard.domain.entity.User
import java.time.LocalDateTime


data class BoardDTO(

    var boardNo : Long = 0,
    var userNo : User? = null,
    var title : String? = null,
    var content : String? = null,
    var createdDate: LocalDateTime? = null,
    var lastModifiedDate: LocalDateTime? = null
) {
    fun toEntity() : Board{
        return Board(boardNo, userNo, title, content, createdDate, lastModifiedDate)
    }

    fun toBoardDTO(board: Board) : BoardDTO{
        return BoardDTO(board.boardNo, board.userNo, board.title, board.content, board.createdDate, board.lastModifiedDate)
    }
}