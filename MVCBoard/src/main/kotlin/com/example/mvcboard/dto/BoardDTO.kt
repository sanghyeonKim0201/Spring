package com.example.mvcboard.dto

import com.example.mvcboard.domain.entity.Board
import java.time.LocalDateTime


data class BoardDTO(

    var id : Long = 0,
    var author : String?,
    var title : String?,
    var content : String?,
    var createDate : String?,
    var lastDate : String?
    ) {
    fun toEntity() : Board{
        var board : Board = Board(id = id
            , author =  author
            , title = title
            , content = content
            , createDate = createDate
            , lastDate = lastDate)
        return board
    }

    fun toBoardDTO(board: Board) : BoardDTO{
        return BoardDTO(
            id = board.id,
            author = board.author,
            title = board.title,
            content = board.content,
            createDate = board.createDate,
            lastDate = board.lastDate
            )
    }
}