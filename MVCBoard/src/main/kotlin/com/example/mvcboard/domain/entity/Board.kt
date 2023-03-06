package com.example.mvcboard.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

    @Column(length = 10, nullable = false)
    var author : String,

    @Column(length = 100, nullable = false)
    var title : String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content : String?,

    @CreatedDate
    var createDate : LocalDateTime,

    @LastModifiedDate
    var lastDate : LocalDateTime
)
