package com.example.posts.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CommentEntity (
    @PrimaryKey
    val id: Int,
    val body: String,
    val email: String,
    val name: String,
    val postId: Int
)