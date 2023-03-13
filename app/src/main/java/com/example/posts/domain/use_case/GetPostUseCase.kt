package com.example.posts.domain.use_case

import android.util.Log
import com.example.posts.domain.model.Post
import com.example.posts.domain.repositories.PostRepository
import javax.inject.Inject
import com.example.posts.data.Result

class GetPostUseCase @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(id: Int): Result<Post> {
        Log.i("useCase", id.toString())
        return repository.getPost(id)
    }
}