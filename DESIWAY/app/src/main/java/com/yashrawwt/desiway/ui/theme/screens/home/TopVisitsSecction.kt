package com.yashrawwt.desiway.ui.theme.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yashrawwt.desiway.ui.theme.components.PlaceCard
import org.w3c.dom.Text

@Composable
fun TopVisitsSection(){
    Column(modifier = Modifier.padding(top = 20.dp)){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Top Visits", style = MaterialTheme.typography.headlineMedium)
            Text("View all", style = MaterialTheme.typography.bodyMedium)
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
                    location = "Agra"
                )
            }
            item {
                PlaceCard(
                    imageUrl = "https://images.unsplash.com/photo-1603874511427-dc9c9fbb57c1",
                    placeName = "Golden Temple",
                    location = "Amritsar"
                )
            }
        }
    }
}