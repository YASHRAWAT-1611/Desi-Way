package com.yashrawwt.desiway.ui.theme.screens.food

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop
import com.yashrawwt.desiway.ui.theme.data.FavoriteRepository
import com.yashrawwt.desiway.ui.theme.data.FoodRepository
import com.yashrawwt.desiway.ui.theme.models.FavoriteType
import com.yashrawwt.desiway.ui.theme.models.Food
import com.yashrawwt.desiway.ui.theme.models.FoodCategory
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

/* ---------------- FILTER ---------------- */

enum class FoodFilter { ALL, VEG, NON_VEG }

/* ---------------- MAIN SCREEN ---------------- */

@Composable
fun FoodScreen(navController: NavHostController) {

    var selectedFilter by remember { mutableStateOf(FoodFilter.ALL) }

    // 🔥 Observe favourites (THIS IS IMPORTANT)
    val favorites = FavoriteRepository.favorites

    val foods = FoodRepository.foods

    val filteredFoods by remember {
        derivedStateOf {
            when (selectedFilter) {
                FoodFilter.ALL -> foods
                FoodFilter.VEG -> foods.filter { it.isVeg }
                FoodFilter.NON_VEG -> foods.filter { !it.isVeg }
            }
        }
    }

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(listOf(MustardTop, MustardBottom))
                )
                .padding(padding)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(22.dp),
                modifier = Modifier.fillMaxSize()
            ) {

                item { FoodHeader() }

                item {
                    FoodFilterToggle(
                        selected = selectedFilter,
                        onSelect = { selectedFilter = it }
                    )
                }

                FoodCategory.values().forEach { category ->
                    val categoryItems =
                        filteredFoods.filter { it.category == category }

                    if (categoryItems.isNotEmpty()) {
                        item {
                            FoodCategorySection(
                                title = category.name.replace("_", " "),
                                items = categoryItems,
                                favorites = favorites,
                                navController = navController
                            )
                        }
                    }
                }

                item { Spacer(Modifier.height(40.dp)) }
            }
        }
    }
}

/* ---------------- FILTER TOGGLE ---------------- */

@Composable
private fun FoodFilterToggle(
    selected: FoodFilter,
    onSelect: (FoodFilter) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(Color.White.copy(alpha = 0.15f), RoundedCornerShape(30.dp))
            .padding(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        FoodFilter.values().forEach { filter ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (selected == filter) Color.Black else Color.Transparent)
                    .clickable { onSelect(filter) }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = filter.name.replace("_", " "),
                    color = if (selected == filter) Color.White else Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

/* ---------------- HEADER ---------------- */

@Composable
private fun FoodHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Text(
                text = "Food",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)

            Spacer(Modifier.height(12.dp))

            Text("Confused what to eat", fontWeight = FontWeight.SemiBold)
            Text("Check the Indian Menu")
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

/* ---------------- CATEGORY SECTION ---------------- */

@Composable
private fun FoodCategorySection(
    title: String,
    items: List<Food>,
    favorites: List<FavoriteRepository.FavoriteItem>,
    navController: NavHostController
) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(items.size) { index ->
                val food = items[index]

                val isFavorite = favorites.any {
                    it.id == food.id && it.type == FavoriteType.FOOD
                }

                FoodCard(
                    food = food,
                    isFavorite = isFavorite,
                    onFavoriteToggle = {
                        FavoriteRepository.toggleFavorite(
                            id = food.id,
                            type = FavoriteType.FOOD
                        )
                    },
                    onClick = {
                        navController.navigate(
                            "${FeatureRoutes.FOOD_DETAIL}/${food.id}"
                        )
                    }
                )
            }
        }
    }
}

/* ---------------- FOOD CARD ---------------- */

@Composable
private fun FoodCard(
    food: Food,
    isFavorite: Boolean,
    onFavoriteToggle: () -> Unit,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(18.dp))
            .clickable { onClick() }
    ) {

        AsyncImage(
            model = food.image,
            contentDescription = food.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = if (isFavorite) Color.Red else Color.White,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .scale(1.2f)
                .clickable { onFavoriteToggle() }
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.55f))
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = food.name,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
