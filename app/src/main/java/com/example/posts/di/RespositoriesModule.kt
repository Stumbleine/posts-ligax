package com.example.posts.di

import com.example.posts.data.repositories.PostRepositoryImp
import com.example.posts.domain.repositories.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RespositoriesModule {

    @Binds
    abstract fun bindPostRepository(impl:PostRepositoryImp):PostRepository
}