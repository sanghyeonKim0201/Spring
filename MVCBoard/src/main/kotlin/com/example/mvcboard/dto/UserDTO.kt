package com.example.mvcboard.dto

import com.example.mvcboard.domain.entity.User
import java.time.LocalDate

data class UserDTO(
    var userNo : Long = 0,
    var name : String? = null,
    var id : String? = null,
    var pw : String? = null,
    var phone : String? = null,
    var birth : LocalDate? = null
){
    fun toEntity() : User{
        var user = User(
            userNo = userNo,
            name = name,
            id = id,
            pw = pw,
            phone = phone,
            birth = birth)
        return user
    }

    fun toUserDTO(user: User) : UserDTO{
        return UserDTO(
            userNo = user.userNo,
            name = user.name,
            id = user.id,
            pw = user.pw,
            phone = user.phone,
            birth = user.birth
        )
    }
}
