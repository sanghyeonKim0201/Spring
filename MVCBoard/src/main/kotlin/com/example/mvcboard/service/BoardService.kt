package com.example.mvcboard.service

import com.example.mvcboard.domain.Repository.BoardRepository
import com.example.mvcboard.domain.entity.Board
import com.example.mvcboard.dto.BoardDto
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService(private var boardRepository: BoardRepository) { //생성자가 하나일 경우 @Autowired 생략 가능

    fun savePost(boardDto: BoardDto) : Long{
        return boardRepository.save(boardDto.toEntity()).id
    }

}