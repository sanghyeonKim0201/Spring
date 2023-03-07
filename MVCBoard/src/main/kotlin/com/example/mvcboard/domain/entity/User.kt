package com.example.mvcboard.domain.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@EntityListeners(AuditingEntityListener::class)
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Long = 0,

    @Column(length = 10, nullable = false)
    var name : String?,

    @Column(length = 100, nullable = false)
    var id : String?,

    @Column(length = 100, nullable = false)
    var pw : String?,

    @Column(length = 13, nullable = false)
    var phone : String?,

    @Column(length = 10, nullable = false)
    var birth : String?
)