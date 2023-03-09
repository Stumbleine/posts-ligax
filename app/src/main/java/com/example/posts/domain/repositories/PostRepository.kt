package com.example.posts.domain.repositories

import com.example.posts.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts():Flow<com.example.posts.data.Result<List<Post>>>

    suspend fun getPost(id:Int):com.example.posts.data.Result<Post>
}