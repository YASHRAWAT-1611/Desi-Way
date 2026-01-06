package com.yashrawwt.desiway.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.data.FavoriteRepository
import com.yashrawwt.desiway.ui.theme.models.FavoriteType

@Composable
fun PlaceCard(
    placeId: String,          // REQUIRED
    imageUrl: String,
    placeName: String,
    location: String,
    onClick: () -> Unit
) {

    val isFavorite = FavoriteRepository.isFavorite(
        id = placeId,
        type = FavoriteType.PLACE
    )

    Box(
        modifier = Modifier
            .width(300.dp)
            .height(210.dp)
            .clip(RoundedCornerShape(22.dp))
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(22.dp),
                ambientColor = Color.Black.copy(0.3f)
            )
            .clickable { onClick() }
    ) {

        /* ---------- IMAGE ---------- */
        AsyncImage(
            model = imageUrl,
            contentDescription = placeName,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        /* ---------- GRADIENT ---------- */
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        )
                    )
                )
        )

        /* ---------- FAVORITE HEART ---------- */
        Box(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.TopEnd)
        ) {
            AnimatedHeart(
                isFavorite = isFavorite,
                onToggle = {
                    FavoriteRepository.toggleFavorite(
                        id = placeId,
                        type = FavoriteType.PLACE
                    )
                }
            )
        }

        /* ---------- TEXT ---------- */
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = placeName,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = location,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}
