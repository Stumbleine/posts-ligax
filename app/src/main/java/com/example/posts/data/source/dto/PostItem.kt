package com.example.posts.data.source.dto

import com.example.posts.domain.model.Post

data class PostItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostItem.toPost(): Post {
    return Post(
        id = id,
        body = body,
        title = title,
        userId = userId
    )
}
