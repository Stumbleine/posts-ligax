package com.example.posts.data.repositories

import android.util.Log
import com.example.posts.data.source.remote.PostsApi
import com.example.posts.domain.model.Post
import com.example.posts.domain.repositories.PostRepository
import com.example.posts.data.Result
import com.example.posts.data.source.dto.toListPosts
import com.example.posts.data.source.dto.toPost
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private val api: PostsApi
) : PostRepository {
    override fun getPosts(): Flow<com.example.posts.data.Result<List<Post>>> = flow {
        emit(Result.Loading())
        try {
            val response = api.getPosts()
            Log.i("response==>", response.toString())

            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(
                Result.Error(

                    message = "No se pudo cargar los datos",
                    data = null
                )
            )

        } catch (e: IOException) {
            emit(Result.Error(
                message = "Couldn't reach server, check your internet connection",
                data = null
            ))
        }
    }

    override suspend fun getPost(id: Int): Result<Post> {
        val response = try{
            api.getPost(id).toPost()
        }catch (e:Exception){
            return Result.Error("Algo salio mal")
        }
        return Result.Success(response)
    }


}