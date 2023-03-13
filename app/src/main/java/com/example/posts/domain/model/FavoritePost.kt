package com.example.posts.domain.model

data class FavoritePost(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int,
    val favorite: Boolean
)