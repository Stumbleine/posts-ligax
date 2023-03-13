package com.example.posts.domain.use_case

import com.example.posts.domain.model.User
import com.example.posts.domain.repositories.PostRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(userId: Int): com.example.posts.data.Result<User> {
        return repository.getUser(userId)
    }
}