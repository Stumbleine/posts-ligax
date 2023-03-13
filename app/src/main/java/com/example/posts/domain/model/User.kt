package com.example.posts.domain.model

import com.example.posts.data.source.dto.Address
import com.example.posts.data.source.dto.Company
import com.example.posts.data.source.dto.PostItem


data class User (
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)

