package com.example.mvcboard.domain.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@EntityListeners(AuditingEntityListener::class)
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var u_no: Long = 0,

    @Column(length = 10, nullable = false)
    var u_name : String,

    @Column(length = 100, nullable = false)
    var u_id : String,

    @Column(length = 100, nullable = false)
    var u_pw : String,

    @Column(length = 13, nullable = false)
    var u_phone : String,

    @Column(length = 10, nullable = false)
    var u_birth : String
)