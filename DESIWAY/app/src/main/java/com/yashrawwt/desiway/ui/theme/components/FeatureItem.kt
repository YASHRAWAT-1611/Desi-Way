package com.yashrawwt.desiway.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FeatureItem(title: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(70.dp)
    ){
        Surface (
            shape = MaterialTheme.shapes.large,
            tonalElevation = 4.dp,
            modifier = Modifier.size(56.dp)
        ) {}
        Spacer(modifier = Modifier.height(6.dp))
        Text(title, style = MaterialTheme.typography.bodySmall)
    }
}