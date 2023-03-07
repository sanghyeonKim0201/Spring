package com.example.mvcboard.dto

import com.example.mvcboard.domain.entity.User

data class UserDTO(
    var no : Long = 0,
    var name : String? = null,
    var id : String? = null,
    var pw : String? = null,
    var phone : String? = null,
    var birth : String? = null
){
    fun toEntity() : User{
        var user = User(
            no = no,
            name = name,
            id = id,
            pw = pw,
            phone = phone,
            birth = birth)
        return user
    }

    fun toUserDTO(user: User) : UserDTO{
        return UserDTO(
            no = user.no,
            name = user.name,
            id = user.id,
            pw = user.pw,
            phone = user.phone,
            birth = user.birth
        )
    }
}
