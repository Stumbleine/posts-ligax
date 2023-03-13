package com.example.posts.data.mapper

import com.example.posts.data.database.PostEntity
import com.example.posts.domain.model.FavoritePost
import com.example.posts.domain.model.Post

fun Post.toEntity():PostEntity{
    return PostEntity(
        id=id,
        title=title,
        body=title,
        userId = userId,
        favorite = false,
    )
}

fun PostEntity.toFavoritePost():FavoritePost{
    return FavoritePost(
        id=id,
        title=title,
        body=title,
        userId = userId,
        favorite= favorite
    )
}

fun PostEntity.toPostModel():Post{
    return Post(
        id=id,
        title=title,
        body=title,
        userId = userId
    )
}
