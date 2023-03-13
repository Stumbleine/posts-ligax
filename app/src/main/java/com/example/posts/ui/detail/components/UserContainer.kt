package com.example.posts.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.posts.R
import com.example.posts.domain.model.User
import com.example.posts.ui.theme.myTheme

@Composable
fun UserContainer(
    user: User?
) {
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
}
