package com.example.posts.data.repositories

import android.util.Log
import com.example.posts.data.source.remote.PostsApi
import com.example.posts.domain.model.Post
import com.example.posts.domain.repositories.PostRepository
import com.example.posts.data.Result
import com.example.posts.data.database.*
import com.example.posts.data.mapper.toEntity
import com.example.posts.data.mapper.toFavoritePost
import com.example.posts.data.mapper.toPostModel
import com.example.posts.data.source.dto.toComment

import com.example.posts.data.source.dto.toPost
import com.example.posts.data.source.dto.toUser
import com.example.posts.domain.model.Comment
import com.example.posts.domain.model.FavoritePost
import com.example.posts.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private val api: PostsApi,
    private val roomRepository: RoomRepository
) : PostRepository {

    override fun getPosts(): Flow<Result<List<FavoritePost>>> = flow {
        emit(Result.Loading())
        try {
            var localPosts = roomRepository.getPosts();
            if (localPosts.isEmpty()) {
                val response = api.getPosts()
                response.forEach {
                    roomRepository.insertPost(it.toEntity())
                }
                localPosts = roomRepository.getPosts()
                Log.i("localPosts", localPosts.toString())
                emit(Result.Success(localPosts.map { it.toFavoritePost() }))
            }
            emit(Result.Success(localPosts.map { it.toFavoritePost() }))
        } catch (e: HttpException) {
            emit(
                Result.Error(
                    message = "No se pudo cargar los datos",
                    data = null
                )
            )

        } catch (e: IOException) {
            emit(
                Result.Error(
                    message = "Couldn't reach server, check your internet connection",
                    data = null
                )
            )
        }
    }

    override suspend fun getPost(id: Int): Result<Post> {
        Log.i("getP??stRepository", id.toString())
        val response = try {
            api.getPost(id)
        } catch (e: Exception) {
            Log.i("POST", "quien sabe que paso")

            return Result.Error("Algo salio mal")

        }
        Log.i("POST", response.toString())
        return Result.Success(response.toPost())
    }

    override suspend fun getUser(userId: Int): Result<User> {
        val response = try {
            api.getUser(userId)
        } catch (e: Exception) {
            return Result.Error("Algo salio mal")
        }
        Log.i("POST", response.toString())
        return Result.Success(response.toUser())
    }

    override suspend fun getComments(PostId: Int): Result<List<Comment>> {
        val response = try {
            api.getComments(PostId)
        } catch (e: Exception) {
            return Result.Error("Algo salio mal")
        }
        Log.i("POST", response.toString())
        return Result.Success(response.map { it.toComment() })
    }

    override suspend fun getFavorites(): Result<List<FavoritePost>> {
        val response = try {
            roomRepository.getFavorites().map { it.toFavoritePost() }
        } catch (e: Exception) {
            return Result.Error("Algo salio mal")
        }
        return Result.Success(response)
    }

    override suspend fun updatePost(id: Int, favorite: Boolean) {
        roomRepository.updatePost(id, favorite)
    }

    override suspend fun deletePost(id: Int) {
        roomRepository.deletePost(id)
    }

    override suspend fun deleteAllPosts() {
        roomRepository.deleteAll()
    }
}
