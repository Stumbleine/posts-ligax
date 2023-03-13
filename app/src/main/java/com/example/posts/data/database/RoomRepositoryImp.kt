package com.example.posts.data.database

import javax.inject.Inject

class RoomRepositoryImp @Inject constructor(
    private val postDao: PostDao,
) : RoomRepository {
    override suspend fun getPosts(): List<PostEntity> {
        return postDao.getPostsFromRoom()
    }

    override suspend fun insertPost(post: PostEntity) {
        postDao.insertPost(post)
    }

    override suspend fun getFavorites(): List<PostEntity> {
        return postDao.getFavorites()
    }

    override suspend fun updatePost(id:Int,favorite:Boolean) {
        return postDao.update(id,favorite)
    }

    override suspend fun deletePost(id: Int) {
       return postDao.delete(id)
    }
    override suspend fun deleteAll() {
        return postDao.deleteAll()
    }
}