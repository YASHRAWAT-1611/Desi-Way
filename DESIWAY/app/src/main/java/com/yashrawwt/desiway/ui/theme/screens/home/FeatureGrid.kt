package com.yashrawwt.desiway.ui.theme.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yashrawwt.desiway.ui.theme.components.FeatureItem
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

data class Feature(
    val title: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun FeatureGrid(navController: NavHostController) {

    val features = listOf(
        Feature("Emergency", Icons.Filled.Warning, FeatureRoutes.EMERGENCY),
        Feature("Scam Alert", Icons.Filled.Report, FeatureRoutes.SCAM),
        Feature("Translate", Icons.Filled.Translate, FeatureRoutes.TRANSLATE),
        Feature("Food", Icons.Filled.Restaurant, FeatureRoutes.FOOD),
        Feature("Travel", Icons.Filled.DirectionsBus, FeatureRoutes.TRAVEL),
        Feature("Adventure", Icons.Filled.Hiking, FeatureRoutes.ADVENTURE),
        Feature("Culture", Icons.Filled.Festival, FeatureRoutes.CULTURE),
        Feature("Maps", Icons.Filled.Map, FeatureRoutes.MAPS)
    )

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        features.chunked(4).forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                rowItems.forEach { feature ->
                    FeatureItem(
                        icon = feature.icon,
                        title = feature.title,
                        onClick = { navController.navigate(feature.route) }
                    )
                }
            }
        }
    }
}
