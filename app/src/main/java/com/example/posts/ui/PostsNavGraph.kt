package com.example.posts.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.posts.ui.components.Splash
import com.example.posts.ui.components.SplashScreen
import com.example.posts.ui.detail.PostDetailScreen
import com.example.posts.ui.home.HomeScreen

@Composable
fun PostsNavGraph(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.Splash.route){

            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(onItemClicked = { navigateToDetail(it) })
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) {
            PostDetailScreen()
        }
    }
}