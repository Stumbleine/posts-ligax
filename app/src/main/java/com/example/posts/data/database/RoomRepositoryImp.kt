package com.example.posts.data.database

import javax.inject.Inject

class RoomRepositoryImp @Inject constructor(private val postDao: PostDao):RoomRepository {
    override suspend fun getPosts(): List<PostEntity> {
        return postDao.getPostsFromRoom()
    }

    override suspend fun insertPost(post: PostEntity) {
        postDao.insertPost(post)
    }
}