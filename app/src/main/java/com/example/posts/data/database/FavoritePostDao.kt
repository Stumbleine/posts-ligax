package com.example.posts.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritePostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite( favoritePostEntity: FavoritePostEntity)

    @Query("SELECT * FROM FavoritePostEntity")
    suspend fun getFavorites():List<FavoritePostEntity>

    @Query("DELETE FROM FavoritePostEntity  WHERE id = :id")
    suspend fun  deleteFavorite(id:Int)


}