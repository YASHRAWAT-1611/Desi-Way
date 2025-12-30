package com.yashrawwt.desiway.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MapPreviewCard() {
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .height(180.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        AsyncImage(
            model = "https://cdn.prod.website-files.com/5c29380b1110ec92a203aa84/66e5ce469b48938aa34d8684_Google%20Maps%20-%20Compressed.jpg",
            contentDescription = "Map Preview",
            contentScale = ContentScale.Crop
        )
    }
}
