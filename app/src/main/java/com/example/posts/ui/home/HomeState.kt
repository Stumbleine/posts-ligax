package com.example.posts.ui.home

import com.example.posts.domain.model.Post

data class HomeState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
)