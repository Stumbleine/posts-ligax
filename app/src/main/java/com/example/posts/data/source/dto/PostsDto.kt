package com.example.posts.data.source.dto

import com.example.posts.domain.model.Post

data class PostsDto( val results : ArrayList<PostItem>)

fun PostsDto.toListPosts(): List<Post> {
    val resultEntries = results.mapIndexed { _, entries ->
        Post(
            id = entries.id,
            body = entries.body,
            title = entries.title,
            userId = entries.userId
        )
    }
    return resultEntries
}