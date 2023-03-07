package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.BoardRepository
import com.example.mvcboard.dto.BoardDTO
import org.springframework.stereotype.Service

@Service
class BoardService(private var boardRepository: BoardRepository) { //생성자가 하나일 경우 @Autowired 생략 가능

    fun savePost(boardDto: BoardDTO) : Long{
        return boardRepository.save(boardDto.toEntity()).id
    }

}