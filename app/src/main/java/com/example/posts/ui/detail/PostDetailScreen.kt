package com.example.posts.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.posts.ui.components.TopBar
import com.example.posts.ui.detail.components.PostDetailCard

@Composable
fun PostDetailScreen(
    viewModel: PostDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state
    Scaffold(
        topBar = {
            TopBar(title = "", navController = navController, { openMenu() })
        }
    ) {
        PostDetailCard(
            post = state.post,
            user = state.user,
            comments = state.comments
        )
    }
}

fun openMenu() {
}