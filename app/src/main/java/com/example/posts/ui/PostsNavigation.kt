package com.example.posts.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

sealed class Screen(val route: String) {
    object Splash: Screen("splash")

    object Home: Screen("home")
    object Detail: Screen("detail?id={id}") {
        fun passId(id: Int): String {
            return "detail?id=$id"
        }
    }
}

class PostsActions(navController: NavController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(Screen.Home.route){

           popUpTo(navController.graph.findStartDestination().id){
           saveState = true

           }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToDetail = {id: Int ->
        navController.navigate(Screen.Detail.passId(id)){
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}