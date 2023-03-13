package com.example.posts.data.database

interface RoomRepository {
    suspend fun getPosts(): List<PostEntity>

    suspend fun insertPost(post:PostEntity)

   suspend fun getFavorites():List<PostEntity>

   suspend fun updatePost(id:Int,favorite:Boolean)

   suspend fun deletePost(id:Int)
    suspend fun deleteAll()
}