package com.example.posts.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.posts.ui.theme.myTheme

@Composable
fun TopBar (title: String, navController: NavController, openMenu: ()->Unit){
    TopAppBar(
        backgroundColor = MaterialTheme.myTheme.primary,
        title = { Text(
            text = title,
            color = MaterialTheme.myTheme.textPrimary
        ) },
        navigationIcon = {
            if(title == ""){
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                }
            }else{
                IconButton(onClick = { openMenu()}) {
                    Icon(Icons.Filled.Menu, contentDescription = null, tint = Color.White)
                }
            }
        },
        actions = {
            if(title == ""){
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Refresh, contentDescription = null, tint = Color.White)
                }
            }
        }
    )
}