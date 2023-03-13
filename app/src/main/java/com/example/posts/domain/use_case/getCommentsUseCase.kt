package com.example.posts.domain.use_case

import com.example.posts.domain.model.Comment
import com.example.posts.domain.repositories.PostRepository
import javax.inject.Inject
import com.example.posts.data.Result
class getCommentsUseCase @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(postId: Int): Result<List<Comment>> {
        return repository.getComments(postId)
    }
}