package com.example.posts.ui.detail

import com.example.posts.domain.model.Comment
import com.example.posts.domain.model.Post
import com.example.posts.domain.model.User

data class DetailState(
    val post: Post? = null,
    val isLoading: Boolean = false,
    val user: User? = null,
    val comments: List<Comment> = emptyList()
)
