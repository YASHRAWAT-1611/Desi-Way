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
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop

/* ---------------- MAIN SCREEN ---------------- */

@Composable
fun FoodScreen() {

    var selectedFilter by remember { mutableStateOf(FoodFilter.ALL) }

    val favorites = remember { mutableStateListOf<String>() }

    val filteredItems by remember {
        derivedStateOf {
            when (selectedFilter) {
                FoodFilter.ALL -> allFood
                FoodFilter.VEG -> allFood.filter { it.isVeg }
                FoodFilter.NON_VEG -> allFood.filter { !it.isVeg }
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
                        filteredItems.filter { it.category == category }

                    if (categoryItems.isNotEmpty()) {
                        item {
                            FoodCategorySection(
                                title = category.name.replace("_", " "),
                                items = categoryItems,
                                favorites = favorites
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
                    .background(
                        if (selected == filter) Color.Black else Color.Transparent
                    )
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
    items: List<FoodItemData>,
    favorites: SnapshotStateList<String>
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
                val item = items[index]

                FoodCard(
                    item = item,
                    isFavorite = favorites.contains(item.id),
                    onFavoriteClick = {
                        if (favorites.contains(item.id))
                            favorites.remove(item.id)
                        else
                            favorites.add(item.id)
                    }
                )
            }
        }
    }
}

/* ---------------- FOOD CARD ---------------- */

@Composable
private fun FoodCard(
    item: FoodItemData,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(18.dp))
    ) {

        AsyncImage(
            model = item.image,
            contentDescription = item.name,
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
                .clickable { onFavoriteClick() }
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
                text = item.name,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/* ---------------- DATA ---------------- */

enum class FoodFilter { ALL, VEG, NON_VEG }

enum class FoodCategory { VEGETARIAN, NON_VEGETARIAN, FAST_FOOD, DRINKS }

data class FoodItemData(
    val id: String,
    val name: String,
    val image: String,
    val isVeg: Boolean,
    val category: FoodCategory
)

/* ---------------- DUMMY FOOD ---------------- */

private val allFood = listOf(
    FoodItemData("veg1", "Rajma Chawal",
        "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?q=80&w=735&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.VEGETARIAN),

    FoodItemData("veg2", "Masala Dosa",
        "https://images.unsplash.com/photo-1694849789325-914b71ab4075?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.VEGETARIAN),

    FoodItemData("veg2", "Paneer Tikka",
        "https://images.unsplash.com/photo-1631452180519-c014fe946bc7?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.VEGETARIAN),

    FoodItemData("non1", "Chicken Curry",
        "https://images.unsplash.com/photo-1694579740719-0e601c5d2437?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        false, FoodCategory.NON_VEGETARIAN),

    FoodItemData("non1", "Fish Curry",
        "https://images.unsplash.com/photo-1574484284002-952d92456975?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        false, FoodCategory.NON_VEGETARIAN),

    FoodItemData("non1", "Butter Chicken",
        "https://images.unsplash.com/photo-1728910107534-e04e261768ae?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        false, FoodCategory.NON_VEGETARIAN),

    FoodItemData("fast1", "Samosa",
        "https://images.unsplash.com/photo-1601050690597-df0568f70950?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.FAST_FOOD),

    FoodItemData("fast1", "Pani Puri",
        "https://plus.unsplash.com/premium_photo-1691030658159-e8e29b2b12b9?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.FAST_FOOD),

    FoodItemData("fast1", "Chowmein",
        "https://images.unsplash.com/photo-1617622141675-d3005b9067c5?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.FAST_FOOD),

    FoodItemData("drink1", "Masala Chai",
        "https://images.unsplash.com/photo-1633069683078-b180ba2afd89?q=80&w=735&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.DRINKS),

    FoodItemData("drink1", "Lassi",
        "https://images.unsplash.com/photo-1692620609860-be6717812f71?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.DRINKS),

    FoodItemData("drink1", "Sugarcane Juice",
        "https://images.unsplash.com/photo-1534353473418-4cfa6c56fd38?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        true, FoodCategory.DRINKS),
)
