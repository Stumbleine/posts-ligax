package com.example.posts.domain.repositories

import com.example.posts.domain.model.Comment
import com.example.posts.domain.model.Post
import com.example.posts.domain.model.User
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts():Flow<com.example.posts.data.Result<List<Post>>>

    suspend fun getPost(id:Int):com.example.posts.data.Result<Post>
    suspend fun getUser(userId:Int):com.example.posts.data.Result<User>
    suspend fun getComments(PostId:Int):com.example.posts.data.Result<List<Comment>>
}