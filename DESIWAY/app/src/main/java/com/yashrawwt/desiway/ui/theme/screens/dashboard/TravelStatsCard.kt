package com.yashrawwt.desiway.ui.theme.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yashrawwt.desiway.ui.theme.components.AnimatedCounter

@Composable
fun TravelStatsCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatItem("Distance", 4273, " Kms")
        StatItem("Trips", 24)
        StatItem("States", 18)
    }
}

@Composable
private fun StatItem(
    label: String,
    value: Int,
    suffix: String = ""
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedCounter(
            targetValue = value,
            suffix = suffix,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}
