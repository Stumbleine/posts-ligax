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

    @Query("UPDATE PostEntity SET favorite=:favorite WHERE id = :id")
    suspend fun update(id:Int, favorite:Boolean);

    @Query("SELECT * FROM PostEntity WHERE favorite = 1")
    suspend fun getFavorites():List<PostEntity>

    @Query("DELETE FROM PostEntity WHERE id=:id")
    suspend fun delete(id:Int)

    @Query("DELETE FROM PostEntity")
    suspend fun deleteAll()
}