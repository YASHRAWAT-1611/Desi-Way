package com.yashrawwt.desiway.ui.theme.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Text
import kotlin.math.roundToInt

@Composable
fun AnimatedCounter(
    targetValue: Int,
    style: TextStyle,
    suffix: String = "",
    duration: Int = 900
) {
    val animatedValue = remember { Animatable(0f) }

    LaunchedEffect(targetValue) {
        animatedValue.animateTo(
            targetValue.toFloat(),
            animationSpec = tween(durationMillis = duration)
        )
    }

    Text(
        text = "${animatedValue.value.roundToInt()}$suffix",
        style = style
    )
}
