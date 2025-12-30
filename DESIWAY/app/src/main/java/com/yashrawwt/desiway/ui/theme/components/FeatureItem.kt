package com.yashrawwt.desiway.ui.theme.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FeatureItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    var pressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.92f else 1f,
        animationSpec = tween(120),
        label = "feature_scale"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .scale(scale)
            .clickable(
                indication = rememberRipple(radius = 36.dp),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                pressed = true
                onClick()
                pressed = false
            }
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .background(
                    color = Color(0xFFFFF3E0),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = title)
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text(title, style = MaterialTheme.typography.labelSmall)
    }
}
