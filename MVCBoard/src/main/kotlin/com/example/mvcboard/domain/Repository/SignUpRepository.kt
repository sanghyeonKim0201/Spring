package com.example.mvcboard.domain.Repository

import com.example.mvcboard.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SignUpRepository : JpaRepository<User, Long>{
}