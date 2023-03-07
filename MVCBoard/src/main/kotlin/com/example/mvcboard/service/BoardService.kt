package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.BoardRepository
import com.example.mvcboard.domain.entity.Board
import com.example.mvcboard.dto.BoardDTO
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BoardService(private var boardRepository: BoardRepository) { //생성자가 하나일 경우 @Autowired 생략 가능

    fun savePost(boardDto: BoardDTO) : Long{
        if(boardDto.createDate == null){
            boardDto.createDate = LocalDateTime.now()
            boardDto.lastDate = LocalDateTime.now()
        }
        return boardRepository.save(boardDto.toEntity()).id
    }

    fun getBoardList() : List<BoardDTO>{
        var board = boardRepository.findAll()
        var boardList = mutableListOf<BoardDTO>()

        for(b in board){
            var boardDTO = BoardDTO(
                id = b.id,
                title = b.title,
                content = b.content,
                author = b.author,
                createDate = b.createDate,
                lastDate = b.lastDate
            )

            boardList.add(boardDTO)
        }

        return boardList
    }

}