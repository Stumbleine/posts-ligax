package com.example.posts.ui.components

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.posts.R
import com.example.posts.ui.Screen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController){
    LaunchedEffect(key1 = true ){
        delay(5000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Splash()
}

@Composable
fun Splash(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logotest), contentDescription = "logosplash",
            Modifier.size(150.dp,150.dp) )


    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    Splash()
}

