package com.example.posts.domain.use_case

import com.example.posts.data.source.dto.PostsDto
import com.example.posts.domain.model.Post
import com.example.posts.domain.repositories.PostRepository
import javax.inject.Inject
import com.example.posts.data.Result
import kotlinx.coroutines.flow.Flow

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke():Flow<Result<List<Post>>> {
        return repository.getPosts()
    }
}