package com.example.posts.domain.use_case

import com.example.posts.data.database.PostEntity
import com.example.posts.domain.model.FavoritePost
import com.example.posts.domain.repositories.PostRepository
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(private val repository: PostRepository){

     suspend operator fun invoke():com.example.posts.data.Result<List<FavoritePost>>{
        return repository.getFavorites()
    }
}