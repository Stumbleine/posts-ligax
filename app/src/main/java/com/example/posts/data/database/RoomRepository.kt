package com.example.posts.data.database

interface RoomRepository {
    suspend fun getPosts(): List<PostEntity>

    suspend fun insertPost(post:PostEntity)
}