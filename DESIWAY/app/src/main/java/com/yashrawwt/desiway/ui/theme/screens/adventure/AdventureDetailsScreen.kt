package com.yashrawwt.desiway.ui.theme.screens.adventure

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop
import com.yashrawwt.desiway.ui.theme.data.AdventureRepository

@Composable
fun AdventureDetailScreen(adventureId: String) {

    val adventure = AdventureRepository.getAdventureById(adventureId) ?: return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(MustardTop, MustardBottom))
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Image
            AsyncImage(
                model = adventure.image,
                contentDescription = adventure.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(22.dp))
            )

            // Title
            Text(
                text = adventure.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            //  FIX 1: Location now clearly visible
            Text(
                text = adventure.location,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black.copy(alpha = 0.75f)
            )

            Spacer(modifier = Modifier.height(6.dp))

            //  FIX 2: Difficulty & Duration on separate lines
            Text(
                text = "Difficulty: ${adventure.difficulty}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "Duration: ${adventure.duration}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = adventure.description,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
