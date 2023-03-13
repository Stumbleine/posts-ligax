package com.example.posts.domain.use_case

import com.example.posts.domain.repositories.PostRepository
import javax.inject.Inject

class DeleteAllPostsUseCase @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke() {
        return repository.deleteAllPosts()
    }
}
