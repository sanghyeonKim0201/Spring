package com.example.mvcboard.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "board")
data class Board(
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var boardNo : Long = 0,

    @ManyToOne
    @JoinColumn(name = "userNo")
    var userNo : User? = null,

    @Column
    var title : String? = null,

    @Column
    var content : String? = null,

    @Column(name = "createdDate")
    @CreatedDate
    var createdDate: LocalDateTime? = null,

    @Column(name = "lastModifiedDate")
    @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = null
){

}
