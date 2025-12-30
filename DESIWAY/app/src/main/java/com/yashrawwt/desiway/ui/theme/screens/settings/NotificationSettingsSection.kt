package com.yashrawwt.desiway.ui.theme.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotificationSettingsSection() {

    var push by remember { mutableStateOf(true) }
    var sleep by remember { mutableStateOf(true) }
    var email by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(horizontal = 20.dp)) {

        Text(
            text = "Notifications",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White.copy(alpha = 0.8f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        NotificationToggle("Push notifications", push) { push = it }
        NotificationToggle("Sleep mode", sleep) { sleep = it }
        NotificationToggle("E-mail notifications", email) { email = it }
    }
}

@Composable
fun NotificationToggle(
    title: String,
    value: Boolean,
    onChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, color = Color.White)

        Switch(
            checked = value,
            onCheckedChange = onChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xFF34C759)
            )
        )
    }
}
