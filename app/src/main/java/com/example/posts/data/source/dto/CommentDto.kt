package com.example.posts.data.source.dto

import com.example.posts.domain.model.Comment

data class CommentDto(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)

fun CommentDto.toComment(): Comment {
    return Comment(
        id = id,
        body = body,
        email = email,
        name = name,
        postId=postId
    )
}
