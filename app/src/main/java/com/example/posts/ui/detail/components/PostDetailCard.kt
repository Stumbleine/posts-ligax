package com.example.posts.ui.detail.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.posts.domain.model.Comment
import com.example.posts.domain.model.Post
import com.example.posts.domain.model.User
import com.example.posts.ui.theme.myTheme

@Composable
fun PostDetailCard(
    post: Post?,
    user: User?,
    comments: List<Comment>?
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(10.dp),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.myTheme.paper
    ) {
        Column {
            UserContainer(user = user)
            if (post != null) {
                Text(
                    post.title,
                    Modifier.padding(vertical = 3.dp, horizontal = 10.dp),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.myTheme.textPrimary

                )
                Text(
                    post.body,
                    Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
                    color =MaterialTheme.myTheme.textSecondary
                )
            }
            if (comments != null) {
                CommentsContainer(comments)
            }
        }
    }
}
