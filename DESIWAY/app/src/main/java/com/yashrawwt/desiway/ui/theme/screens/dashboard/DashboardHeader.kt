package com.yashrawwt.desiway.ui.theme.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DashboardHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(
                text = "Hi, John 👋",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Travel distance with us",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Surface(
            shape = CircleShape,
            shadowElevation = 8.dp,
            modifier = Modifier.size(64.dp)
        ) {
            AsyncImage(
                model = "https://i.pravatar.cc/150?img=12",
                contentDescription = "Profile",
                contentScale = ContentScale.Crop
            )
        }
    }
}
