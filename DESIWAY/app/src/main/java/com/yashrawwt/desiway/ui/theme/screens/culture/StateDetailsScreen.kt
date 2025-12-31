package com.yashrawwt.desiway.ui.theme.screens.culture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop

@Composable
fun StateDetailScreen(stateName: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(MustardTop, MustardBottom))
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column {
                Text(
                    text = stateName,
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
                    .clip(CircleShape)
            )
        }

        Text(
            text = "Culture • Food • Festivals • Traditions",
            fontWeight = FontWeight.Medium
        )

        Text(
            text = "About $stateName",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "This section will show detailed cultural information, festivals, traditional food, clothing, language and famous places of $stateName.\n\n(Backend / API coming soon 🚀)",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
