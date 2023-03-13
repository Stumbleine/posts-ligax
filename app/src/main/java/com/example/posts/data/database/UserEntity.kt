package com.example.posts.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.posts.data.source.dto.Address
import com.example.posts.data.source.dto.Company

@Entity

class UserEntity(
    val id: Int,
    @PrimaryKey
    val address: Address,
    val company: Company,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)