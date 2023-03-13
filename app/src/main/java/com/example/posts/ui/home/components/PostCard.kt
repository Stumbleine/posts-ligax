package com.example.posts.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.posts.data.database.PostEntity
import com.example.posts.domain.model.Post
import com.example.posts.ui.theme.myTheme

@Composable
fun PostCard(
    post: Post,
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { onItemClicked(post.id) },
        backgroundColor = MaterialTheme.myTheme.paper,
        elevation = 10.dp
    ) {
        Row(
            Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),

            ) {
            Badge(
                backgroundColor = MaterialTheme.myTheme.secondaryVariant,
                modifier = Modifier
                    .width(10.dp)
                    .height(10.dp),
            )
            Text(
                post.title,
                Modifier
                    .weight(15F),
                textAlign = TextAlign.Start
            )
            Row() {

                IconButton(onClick = { /*TODO*/ },
                    content = {
                        if (true) {
                            Icon(
                                Icons.Outlined.Star,
                                null,
                                tint =
                                Color.Yellow
                            )
                        } else {
                            Icon(
                                Icons.Outlined.Star,
                                null
                            )
                        }
                    }
                )
                IconButton(onClick = { /*TODO*/ },
                    content = {
                        Icon(
                            Icons.Filled.Delete,
                            null,
                            tint = MaterialTheme.myTheme.error,
                        )
                    }
                )
            }


        }
    }
}