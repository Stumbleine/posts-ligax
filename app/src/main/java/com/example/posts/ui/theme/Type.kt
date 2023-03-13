package com.example.posts.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.posts.R

private val Poppins = FontFamily(
    Font(R.font.poppins_light,FontWeight.Light),
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium,FontWeight.Medium),
    Font(R.font.poppins_bold,FontWeight.Bold),
)

val PoppinsTypography = Typography(
    body1 = TextStyle(
        fontFamily =  Poppins,
        fontSize = 16.sp
    )
)