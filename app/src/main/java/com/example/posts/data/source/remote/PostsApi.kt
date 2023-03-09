package com.example.posts.data.source.remote

import com.example.posts.data.source.dto.PostItem
import com.example.posts.data.source.dto.PostsDto
import com.example.posts.domain.model.Post
import retrofit2.http.GET

interface PostsApi {
    @GET("posts")
    suspend fun getPosts():List<Post>
    @GET("characters/{id}")
    suspend fun getPost(id: Int):PostItem


}