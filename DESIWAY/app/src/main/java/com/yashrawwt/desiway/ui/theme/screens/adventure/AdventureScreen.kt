package com.yashrawwt.desiway.ui.theme.screens.adventure

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import com.yashrawwt.desiway.ui.theme.components.AnimatedHeart
import com.yashrawwt.desiway.ui.theme.data.AdventureRepository
import com.yashrawwt.desiway.ui.theme.data.FavoriteRepository
import com.yashrawwt.desiway.ui.theme.models.Adventure
import com.yashrawwt.desiway.ui.theme.models.AdventureCategory
import com.yashrawwt.desiway.ui.theme.models.FavoriteType
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

@Composable
fun AdventureScreen(navController: NavHostController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(MustardTop, MustardBottom))),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {

        item { AdventureHeader() }

        AdventureCategory.values().forEach { category ->
            item {
                AdventureSection(
                    title = category.name.replace("_", " ").lowercase()
                        .replaceFirstChar { it.uppercase() },
                    adventures = AdventureRepository.adventures.filter {
                        it.category == category
                    },
                    navController = navController
                )
            }
        }

        item { Spacer(Modifier.height(40.dp)) }
    }
}

/* ---------------- HEADER ---------------- */

@Composable
private fun AdventureHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Adventure",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)
        }

        AsyncImage(
            model = "https://i.pravatar.cc/150?img=12",
            contentDescription = null,
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

/* ---------------- SECTION ---------------- */

@Composable
private fun AdventureSection(
    title: String,
    adventures: List<Adventure>,
    navController: NavHostController
) {
    Column {

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, bottom = 10.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(adventures.size) { index ->
                AdventureCard(
                    adventure = adventures[index],
                    onClick = {
                        navController.navigate(
                            "${FeatureRoutes.ADVENTURE}/${adventures[index].id}"
                        )
                    }
                )
            }
        }
    }
}

/* ---------------- CARD ---------------- */

@Composable
private fun AdventureCard(
    adventure: Adventure,
    onClick: () -> Unit
) {
    val isFavorite by remember {
        derivedStateOf {
            FavoriteRepository.isFavorite(
                id = adventure.id,
                type = FavoriteType.ADVENTURE
            )
        }
    }

    Box(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
    ) {

        AsyncImage(
            model = adventure.image,
            contentDescription = adventure.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ) {
            AnimatedHeart(
                isFavorite = isFavorite,
                onToggle = {
                    FavoriteRepository.toggleFavorite(
                        id = adventure.id,
                        type = FavoriteType.ADVENTURE
                    )
                }
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.55f))
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = adventure.name,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
