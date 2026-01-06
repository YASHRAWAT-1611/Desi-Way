package com.yashrawwt.desiway.ui.theme.screens.favourite

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop
import com.yashrawwt.desiway.ui.theme.components.AnimatedEnterItem
import com.yashrawwt.desiway.ui.theme.components.FavouriteCard
import com.yashrawwt.desiway.ui.theme.data.AdventureRepository
import com.yashrawwt.desiway.ui.theme.data.FavoriteRepository
import com.yashrawwt.desiway.ui.theme.data.FoodRepository
import com.yashrawwt.desiway.ui.theme.data.PlaceRepository
import com.yashrawwt.desiway.ui.theme.models.FavoriteType
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

@Composable
fun FavouriteScreen(navController: NavController) {

    val favorites = FavoriteRepository.favorites

    val favoritePlaces = remember(favorites) {
        favorites.filter { it.type == FavoriteType.PLACE }
            .mapNotNull { PlaceRepository.places.find { p -> p.id == it.id } }
    }

    val favoriteFoods = remember(favorites) {
        favorites.filter { it.type == FavoriteType.FOOD }
            .mapNotNull { FoodRepository.getFoodById(it.id) }
    }

    val favoriteAdventures = remember(favorites) {
        favorites.filter { it.type == FavoriteType.ADVENTURE }
            .mapNotNull { AdventureRepository.getAdventureById(it.id) }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(MustardTop, MustardBottom))),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        /* ---------- HEADER ---------- */
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Favourites",
                    style = MaterialTheme.typography.headlineMedium
                )

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
        }

        item {
            FavouriteRowSection(
                title = "Destinations",
                items = favoritePlaces
            ) { index ->
                navController.navigate(
                    "${FeatureRoutes.PLACE_DETAIL}/${favoritePlaces[index].id}"
                )
            }
        }

        item {
            FavouriteRowSection(
                title = "Food",
                items = favoriteFoods
            ) { }
        }

        item {
            FavouriteRowSection(
                title = "Adventure",
                items = favoriteAdventures
            ) { index ->
                navController.navigate(
                    "${FeatureRoutes.ADVENTURE}/${favoriteAdventures[index].id}"
                )
            }
        }

        item { Spacer(modifier = Modifier.height(40.dp)) }
    }
}

/* ---------- ROW SECTION ---------- */

@Composable
private fun <T> FavouriteRowSection(
    title: String,
    items: List<T>,
    onClick: (Int) -> Unit
) {
    if (items.isEmpty()) return

    Column {

        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 20.dp),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(items.size) { index ->
                AnimatedEnterItem(index) {
                    Box(modifier = Modifier.clickable { onClick(index) }) {
                        when (val item = items[index]) {
                            is com.yashrawwt.desiway.ui.theme.models.Place ->
                                FavouriteCard(item.image, item.name)

                            is com.yashrawwt.desiway.ui.theme.models.Food ->
                                FavouriteCard(item.image, item.name)

                            is com.yashrawwt.desiway.ui.theme.models.Adventure ->
                                FavouriteCard(item.image, item.name)
                        }
                    }
                }
            }
        }
    }
}
