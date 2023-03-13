package com.example.posts.data.source.dto

import com.example.posts.domain.model.User

data class UserDto(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)
fun UserDto.toUser(): User {
    return User(
        id = id,
        address = address,
        email = email,
        name = name,
        phone = phone,
        username = username,
        website = website,
        company = company
    )
}