package com.example.posts.ui.detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.posts.R
import com.example.posts.domain.model.Comment
import com.example.posts.ui.theme.myTheme

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
