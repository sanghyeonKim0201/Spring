package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.BoardRepository
import com.example.mvcboard.domain.entity.Board
import com.example.mvcboard.dto.BoardDTO
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class BoardService(private var boardRepository: BoardRepository) { //생성자가 하나일 경우 @Autowired 생략 가능

    fun savePost(boardDto: BoardDTO){
        boardRepository.save(boardDto.toEntity())
    }

    fun getBoardList() : List<BoardDTO>{
        var board = boardRepository.findAll()
        var boardList = mutableListOf<BoardDTO>()

        for(b in board){
            var boardDTO = BoardDTO(
                boardNo = b.boardNo,
                title = b.title,
                content = b.content,
                userNo = b.userNo,
                createdDate = b.createdDate,
                lastModifiedDate = b.lastModifiedDate
            )

            boardList.add(boardDTO)
        }

        return boardList
    }

}