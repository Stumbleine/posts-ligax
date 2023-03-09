package com.example.posts.ui.home

import com.example.posts.domain.model.Post

data class HomeState(
    val posts: List<Post> = emptyList(),
//    val showPrevious: Boolean = false,
  //  val showNext: Boolean = false,
  //  val showNext: Boolean = false,
    val isLoading: Boolean = false
)