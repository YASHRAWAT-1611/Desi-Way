package com.yashrawwt.desiway.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FeatureButton(
    icon: @Composable () -> Unit,
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(72.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(72.dp)
                .background(
                    color = Color(0xFFFFF3E0),
                    shape = RoundedCornerShape(18.dp)
                )
        ) {
            icon()
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(text = title)
    }
}

@Composable
fun FeatureGrid() {

    val features = listOf(
        "Emergency",
        "Scam Alert",
        "Translate",
        "Food",
        "Travel",
        "Adventure",
        "Culture",
        "Maps"
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(features) { title ->
            FeatureButton(title = title)
        }
    }
}