package com.yashrawwt.desiway.ui.theme.screens.travel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop
import com.yashrawwt.desiway.ui.theme.data.PlaceRepository
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

@Composable
fun TravelScreen(navController: NavHostController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(MustardTop, MustardBottom))
            ),
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {

        item { TravelHeader() }

        item {
            TravelSection(
                title = "Most Popular",
                placeIds = listOf("taj_mahal", "golden_temple"),
                navController = navController
            )
        }

        item {
            TravelSection(
                title = "Winters Pick",
                placeIds = listOf("auli", "gulmarg"),
                navController = navController
            )
        }

        item {
            TravelSection(
                title = "Summers Pick",
                placeIds = listOf("manali", "leh"),
                navController = navController
            )
        }

        item {
            TravelSection(
                title = "Under Rated",
                placeIds = listOf("spiti", "hampi"),
                navController = navController
            )
        }

        item { Spacer(Modifier.height(40.dp)) }
    }
}

@Composable
private fun TravelHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text("Travel", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)
        }

        AsyncImage(
            model = "https://i.pravatar.cc/150?img=12",
            contentDescription = null,
            modifier = Modifier.size(46.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun TravelSection(
    title: String,
    placeIds: List<String>,
    navController: NavHostController
) {

    val places = PlaceRepository.places.filter { it.id in placeIds }

    Column {
        Text(title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 20.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(places.size) { index ->
                val place = places[index]
                TravelCard(
                    place.name,
                    place.image
                ) {
                    navController.navigate("${FeatureRoutes.PLACE_DETAIL}/${place.id}")
                }
            }
        }
    }
}

@Composable
private fun TravelCard(
    name: String,
    image: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
    ) {

        AsyncImage(
            model = image,
            contentDescription = name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black.copy(0.55f))
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(name, color = Color.White, fontWeight = FontWeight.Medium)
        }
    }
}
