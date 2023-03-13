package com.example.posts.data.source.remote

import com.example.posts.data.source.dto.CommentDto
import com.example.posts.data.source.dto.PostItem
import com.example.posts.data.source.dto.UserDto
import com.example.posts.domain.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApi {
    @GET("posts")
    suspend fun getPosts():List<Post>
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int):PostItem
    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int):UserDto
    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int):List<CommentDto>
}