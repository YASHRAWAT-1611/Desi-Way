package com.yashrawwt.desiway.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = MustardYellow,
    secondary = DeepBlue,
    background = DarkTeal,
    surface = DarkTeal,
    onSurface = White,
    onBackground = White,
    error = AlertRed
)

private val LightColors = lightColorScheme(
    primary = MustardYellow,
    onPrimary = Charcoal,

    secondary = DeepBlue,
    onSecondary = White,

    tertiary = SaffronOrange,

    error = AlertRed,
    onError = White,

    background = White,
    onBackground = Charcoal,
    surface = White,
    onSurface = Charcoal
)

@Composable
fun DesiWayTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        content = content
    )
}