package com.example.mvcboard.dto

import com.example.mvcboard.domain.entity.User
import jakarta.persistence.Column
import jakarta.persistence.Entity

data class UserDto(
    var u_no: Long = 0,
    var u_name : String,
    var u_id : String,
    var u_pw : String,
    var u_phone : String,
    var u_birth : String
){
    fun toEntity() : User{
        var user = User(u_no = u_no,
            u_name = u_name,
            u_id = u_id,
            u_pw = u_pw,
            u_phone = u_phone,
            u_birth = u_birth)
        return user
    }
}
