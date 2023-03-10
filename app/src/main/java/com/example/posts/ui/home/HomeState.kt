package com.example.posts.ui.home

import com.example.posts.domain.model.FavoritePost

data class HomeState(
    val posts: List<FavoritePost> = emptyList(),
    val isLoading: Boolean = false,
    val favorites: List<FavoritePost> = emptyList()
)
