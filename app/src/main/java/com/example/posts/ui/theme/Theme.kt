package com.example.posts.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

data class MyTheme(
    val background: Color,
    val primary: Color,
    val primaryVariant: Color,
    val secondary: Color,
    val secondaryVariant: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textDisabled: Color,
    val error: Color,
    val warning: Color,
    val success: Color,
    val divider: Color,
    val paper: Color,
    val material: Colors
)


private val DarkColorPalette = MyTheme(
    background = BgDark,
    primary = Green,
    primaryVariant = Green100,
    secondary = Purple500,
    secondaryVariant = Purple200,
    textPrimary = Grey100,
    textSecondary = Grey400,
    textDisabled = Grey700,
    error = Red,
    warning = Amber,
    success = Green400,
    paper = DarkLight,
    divider = Grey700,
    material = darkColors(),
    )

private val LightColorPalette = MyTheme(
    background = BgLight,
    primary = Green,
    primaryVariant = Green100,
    secondary = Purple500,
    secondaryVariant = Purple200,
    textPrimary = Grey900,
    textSecondary = Grey700,
    textDisabled = Grey400,
    error = Red,
    warning = Amber,
    success = Green400,
    paper = White,
    divider = Grey400,
    material = lightColors(),
)

private val LocalColors = staticCompositionLocalOf { DarkColorPalette }

@Composable
fun PostsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors =
       if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors = colors.material,
            typography = PoppinsTypography,
            shapes = Shapes,
            content = content
        )
    }

}


val MaterialTheme.myTheme: MyTheme
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current