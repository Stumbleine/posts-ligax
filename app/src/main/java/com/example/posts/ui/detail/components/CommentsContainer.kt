package com.example.posts.ui.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.posts.domain.model.Comment
import com.example.posts.ui.theme.myTheme

@Composable
fun CommentsContainer(comments: List<Comment>) {
    Column {
        Box(modifier = Modifier.padding(10.dp)) {
            Text(text = "Comments", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
        Divider(thickness = 1.dp, color = MaterialTheme.myTheme.divider)
        LazyColumn(
            content = {
                items(comments.size) { index ->
                    Comment(comments[index])
                    if (index < comments.size) {
                        Divider(
                            startIndent = 10.dp,
                            thickness = 1.dp,
                            color = MaterialTheme.myTheme.divider
                        )
                    }

                }
            }
        )
    }
}