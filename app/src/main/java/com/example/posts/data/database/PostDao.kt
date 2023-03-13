package com.example.posts.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(postEntity: PostEntity)

    @Query("SELECT * FROM PostEntity")
    suspend fun getPostsFromRoom():List<PostEntity>
}