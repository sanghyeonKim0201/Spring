package com.example.mvcboard.domain.Repository

import com.example.mvcboard.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository: JpaRepository<User, Long>{
    fun findByIdAndPw(id : String?, pw : String?) : Optional<User>
    fun findById(id : String?) : Optional<User>
    fun findByPw(pw : String?) : Optional<User>
    fun findByUserNo(userNo : Long) : Optional<User>
    fun findByBirth(birth : String?) : Optional<User>
    fun findByName(name : String?) : Optional<User>
    fun findByPhone(phone : String?) : Optional<User>

}