package com.yashrawwt.desiway.ui.theme.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yashrawwt.desiway.ui.theme.components.PlaceCard
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

@Composable
fun TopVisitsSection(
    navController: NavHostController
) {
    Column(modifier = Modifier.padding(top = 20.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Top Visits",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "View all",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable {
                    navController.navigate(FeatureRoutes.TRAVEL)
                }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                PlaceCard(
                    imageUrl = "https://images.unsplash.com/photo-1548013146-72479768bada",
                    placeName = "Taj Mahal",
                    location = "Agra",
                    onClick = {
                        navController.navigate("${FeatureRoutes.PLACE_DETAIL}/taj_mahal")
                    }
                )
            }
            item {
                PlaceCard(
                    imageUrl = "https://plus.unsplash.com/premium_photo-1697730331435-92e07494db43?q=80&w=1025&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    placeName = "Golden Temple",
                    location = "Amritsar",
                    onClick = {
                        navController.navigate("${FeatureRoutes.PLACE_DETAIL}/golden_temple")
                    }
                )
            }
        }
    }
}
