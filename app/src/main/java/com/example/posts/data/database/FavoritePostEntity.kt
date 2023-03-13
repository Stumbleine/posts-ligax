package com.example.posts.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FavoritePostEntity (
    @PrimaryKey()
    val id: Int,
    val body:String,
    val title:String,
    val userId:Int
    )