package com.example.posts.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class,FavoritePostEntity::class], version = 2)
abstract class PostDatabase : RoomDatabase() {
    abstract val dao: PostDao
    abstract val daoFavorite: FavoritePostDao
    companion object {
        private var dbINSTANCE: PostDatabase? = null

        fun getPostDatabase(context: Context): PostDatabase {
            if (dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder<PostDatabase>(
                    context.applicationContext, PostDatabase::class.java, "ZemogaDatabase"
                ).allowMainThreadQueries()
                    .build()
            }
            return dbINSTANCE!!
        }
    }
}