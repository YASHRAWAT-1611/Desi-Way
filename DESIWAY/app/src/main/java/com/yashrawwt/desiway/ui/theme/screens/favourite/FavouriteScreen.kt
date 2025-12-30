package com.yashrawwt.desiway.ui.theme.screens.favourite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop
import com.yashrawwt.desiway.ui.theme.components.FavouriteCard
import com.yashrawwt.desiway.ui.theme.components.AnimatedEnterItem


@Composable
fun FavouriteScreen() {

    val destinations = listOf(
        "https://images.unsplash.com/photo-1696761653275-f9815547ef3e?q=80&w=1029&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" to "Pithoragarh",
        "https://images.unsplash.com/photo-1605649487212-47bdab064df7?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" to "Manali"
    )

    val foods = listOf(
        "https://images.unsplash.com/photo-1589302168068-964664d93dc0?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" to "Hyderabadi Biryani",
        "https://images.unsplash.com/photo-1550547660-d9450f859349" to "Burger"
    )

    val adventure = listOf(
        "https://images.unsplash.com/photo-1642933196504-62107dac9258?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" to "Rafting Rishikesh",
        "https://images.unsplash.com/photo-1719949122509-74d0a1d08b44?q=80&w=736&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" to "Paragliding"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(MustardTop, MustardBottom))
            )
    ) {

        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Favourite", style = MaterialTheme.typography.headlineMedium)

            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(48.dp)
            ) {
                AsyncImage(
                    model = "https://i.pravatar.cc/150?img=12",
                    contentDescription = "Profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
            }
        }

        Section("Destination", destinations)
        Section("Foods", foods)
        Section("Adventure", adventure)
    }
}

@Composable
private fun Section(
    title: String,
    items: List<Pair<String, String>>
) {
    Text(
        text = title,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        style = MaterialTheme.typography.titleMedium
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items.size) { index ->
            AnimatedEnterItem(index = index) {
                FavouriteCard(
                    imageUrl = items[index].first,
                    title = items[index].second
                )
            }
        }
    }

}

