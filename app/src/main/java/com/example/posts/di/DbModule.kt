package com.example.posts.di

import android.content.Context
import androidx.room.Room
import com.example.posts.data.database.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDao(db: PostDatabase) = db.dao

    @Provides
    @Singleton
    fun getPostDatabase (@ApplicationContext context: Context): PostDatabase{
        return PostDatabase.getPostDatabase(context)
    }
}
