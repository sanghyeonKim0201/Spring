package com.example.mvcboard.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "userNo")
    var userNo: Long = 0,

    @Column(length = 10, nullable = false)
    var name : String? = null,

    @Column(length = 100, nullable = false)
    var id : String? = null,

    @Column(length = 100, nullable = false)
    var pw : String? = null,

    @Column(length = 13, nullable = false)
    var phone : String? = null,

    @Column(length = 10, nullable = false)
    var birth : LocalDate? = null
)