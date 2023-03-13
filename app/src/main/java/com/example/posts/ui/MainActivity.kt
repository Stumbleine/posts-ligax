package com.example.posts.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostsApp()
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PostsTheme {
       PostsApp()
    }
}
*/
