package com.example.posts.ui.detail.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.posts.R
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
            .padding(10.dp)
            ,
        elevation = 10.dp,
        backgroundColor = MaterialTheme.myTheme.paper
    ) {
        Column {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "userpicture",
                        Modifier
                            .size(60.dp, 60.dp)
                            .clip(CircleShape)
                    )
                    Column() {
                        if (user != null) {

                            Text(text = user.name, color = MaterialTheme.myTheme.textPrimary)
                            Text(
                                text = user.email,
                                color = MaterialTheme.myTheme.textSecondary
                            )
                            Text(
                                text = user.phone,
                                color = MaterialTheme.myTheme.textSecondary
                            )
                            Text(
                                text = user.company.name,
                                color = MaterialTheme.myTheme.textSecondary
                            )
                        }

                    }
                }
            }
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
                    color = MaterialTheme.myTheme.textSecondary
                )
            }

            if (comments != null) {
                CommentsContainer(comments)
            }
        }
    }
}

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


        // Comment()


    }
}

@Composable
fun Comment(comment: Comment) {
    Box(
        Modifier
            .padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Row(

            horizontalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "userpicture",
                Modifier
                    .padding(top = 5.dp)
                    .size(30.dp, 30.dp)
                    .clip(CircleShape)
            )
            Column {

                Text(
                    text = comment.name,
                    color = MaterialTheme.myTheme.textPrimary
                )
                Text(
                    text = comment.email,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.myTheme.primaryVariant
                )
                Box(
                    Modifier
                        .padding(top = 10.dp)
                        .border(
                            BorderStroke(
                                1.dp,
                                SolidColor(MaterialTheme.myTheme.primaryVariant)
                            ),
                            RoundedCornerShape(10.dp)
                        )
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = comment.body,
                        color = MaterialTheme.myTheme.textSecondary
                    )
                }
            }
        }

    }
}

