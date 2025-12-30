package com.yashrawwt.desiway.ui.theme.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yashrawwt.desiway.ui.theme.components.FeatureItem

@Composable
fun FeatureGrid() {

    val features = listOf(
        Feature("Emergency", Icons.Default.Warning),
        Feature("Scam Alert", Icons.Default.Info),
        Feature("Translate", Icons.Default.Language),
        Feature("Food", Icons.Default.Fastfood),
        Feature("Travel", Icons.Default.DirectionsBus),
        Feature("Adventure", Icons.Default.Explore),
        Feature("Culture", Icons.Default.Public),
        Feature("Maps", Icons.Default.Map)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(features.size) { index ->
            FeatureItem(
                icon = features[index].icon,
                title = features[index].title
            )
        }
    }
}


data class Feature(
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)
