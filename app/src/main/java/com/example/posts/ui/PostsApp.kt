package com.example.posts.ui

import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.posts.ui.components.TopBar
import com.example.posts.ui.theme.PostsTheme

@Composable
fun PostsApp() {
    PostsTheme() {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            PostsActions(navController)
        }

        PostsNavGraph(
            navController = navController,
            navigateToHome = navigationActions.navigateToHome,
            navigateToDetail = navigationActions.navigateToDetail
        )
    }
}