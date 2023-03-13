package com.example.posts.domain.use_case

import com.example.posts.domain.repositories.PostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(id: Int) {}
}
