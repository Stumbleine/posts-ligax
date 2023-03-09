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
            /*
            PostsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(onItemClicked = {})

                   // Greeting("Android")
                }
            }

             */
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PostsTheme {
        HomeScreen(onItemClicked = {})
    }
}
*/
