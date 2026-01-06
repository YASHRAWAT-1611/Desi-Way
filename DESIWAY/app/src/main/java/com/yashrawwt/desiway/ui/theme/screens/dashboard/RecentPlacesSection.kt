package com.yashrawwt.desiway.ui.theme.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yashrawwt.desiway.ui.theme.components.PlaceCard
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

@Composable
fun RecentPlacesSection(navController: NavController) {

    Text(
        text = "Recent Places",
        modifier = Modifier.padding(horizontal = 20.dp),
        style = MaterialTheme.typography.titleMedium
    )

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            PlaceCard(
                placeId = "nainital",
                imageUrl = "https://images.unsplash.com/photo-1706468630738-b0ded0c5fc25?q=80&w=899&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                placeName = "Nainital",
                location = "Uttarakhand",
                onClick = {
                    navController.navigate("${FeatureRoutes.PLACE_DETAIL}/nainital")
                }
            )
        }
        item {
            PlaceCard(
                placeId = "jaipur",
                imageUrl = "https://images.unsplash.com/photo-1599661046289-e31897846e41?q=80&w=627&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                placeName = "Jaipur",
                location = "Rajasthan",
                onClick = {
                    navController.navigate("${FeatureRoutes.PLACE_DETAIL}/jaipur")
                }
            )
        }
        item {
            PlaceCard(
                placeId = "ladakh",
                imageUrl = "https://images.unsplash.com/photo-1617824077360-7a77db40aae1?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                placeName = "Ladakh",
                location = "J&K",
                onClick = {
                    navController.navigate("${FeatureRoutes.PLACE_DETAIL}/ladakh")
                }
            )
        }
    }
}
