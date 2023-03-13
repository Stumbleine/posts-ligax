package com.example.posts.domain.model

class Comment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)