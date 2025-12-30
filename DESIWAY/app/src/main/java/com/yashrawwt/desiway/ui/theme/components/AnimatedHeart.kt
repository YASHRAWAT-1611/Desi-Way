package com.yashrawwt.desiway.ui.theme.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun AnimatedHeart(
    isFavorite: Boolean,
    onToggle: () -> Unit,
    size: Int = 26
) {
    val scale = remember { Animatable(1f) }
    var showSparkle by remember { mutableStateOf(false) }

    LaunchedEffect(isFavorite) {
        if (isFavorite) {
            scale.animateTo(
                targetValue = 1.4f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            scale.animateTo(1f)
            showSparkle = true
        }
    }

    Box(
        modifier = Modifier
            .size(size.dp)
            .clickable {
                onToggle()
            }
    ) {
        Icon(
            imageVector = if (isFavorite)
                Icons.Filled.Favorite
            else
                Icons.Outlined.FavoriteBorder,
            contentDescription = "Favorite",
            tint = if (isFavorite) Color.Red else Color.White,
            modifier = Modifier
                .size(size.dp)
                .graphicsLayer {
                    scaleX = scale.value
                    scaleY = scale.value
                }
        )

        if (showSparkle) {
            SparkleEffect {
                showSparkle = false
            }
        }
    }
}

@Composable
private fun SparkleEffect(onFinish: () -> Unit) {

    val alpha = remember { Animatable(1f) }

    LaunchedEffect(Unit) {
        alpha.animateTo(
            targetValue = 0f,
            animationSpec = tween(400)
        )
        onFinish()
    }

    Canvas(modifier = Modifier.size(36.dp)) {
        repeat(6) {
            val angle = Random.nextFloat() * 360f
            val radius = Random.nextFloat() * 12f + 6f
            val x = center.x + radius * kotlin.math.cos(Math.toRadians(angle.toDouble())).toFloat()
            val y = center.y + radius * kotlin.math.sin(Math.toRadians(angle.toDouble())).toFloat()

            drawCircle(
                color = Color.White.copy(alpha = alpha.value),
                radius = 2f,
                center = Offset(x, y)
            )
        }
    }
}

