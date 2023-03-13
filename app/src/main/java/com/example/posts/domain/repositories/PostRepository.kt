package com.example.posts.domain.repositories

import com.example.posts.domain.model.Comment
import com.example.posts.domain.model.Post
import com.example.posts.domain.model.User
import kotlinx.coroutines.flow.Flow
import com.example.posts.data.Result
import com.example.posts.domain.model.FavoritePost

interface PostRepository {
    fun getPosts():Flow<Result<List<FavoritePost>>>
    suspend fun getPost(id:Int):Result<Post>
    suspend fun getUser(userId:Int):Result<User>
    suspend fun getComments(PostId:Int):Result<List<Comment>>
    suspend fun getFavorites():Result<List<FavoritePost>>
    suspend fun updatePost(id:Int, favorite:Boolean)
    suspend fun deletePost(id:Int)
    suspend fun deleteAllPosts()
}
