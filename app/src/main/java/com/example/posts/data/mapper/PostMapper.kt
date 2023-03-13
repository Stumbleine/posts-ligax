package com.example.posts.data.mapper

import androidx.room.Entity
import com.example.posts.data.database.PostEntity
import com.example.posts.data.source.dto.PostsDto
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
/*
fun PostEntity.toPost():PostEntity{
    return PostEntity(
        id=id,
        title=title,
        body=title,
        userId = userId
    )
}
 */
@Entity
data class PostsEntity(
    val results:List<PostEntity>
)

fun PostsEntity.toListPosts(): List<Post> {
    val resultEntries = results.mapIndexed { _, entries ->
        Post(
            id = entries.id,
            body = entries.body,
            title = entries.title,
            userId = entries.userId
        )
    }
    return resultEntries
}

