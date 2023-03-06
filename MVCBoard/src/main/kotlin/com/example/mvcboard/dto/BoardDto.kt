package com.example.mvcboard.dto

import com.example.mvcboard.domain.entity.Board
import java.time.LocalDateTime


data class BoardDto(

    var id : Long = 0,
    var author : String,
    var title : String,
    var content : String,
    var createDate : LocalDateTime,
    var lastDate : LocalDateTime
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
}