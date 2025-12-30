package com.yashrawwt.desiway.ui.theme.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1E)),
        contentPadding = PaddingValues(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item { SettingsHeader() }

        item {
            SettingsSection(
                title = "Account",
                items = listOf(
                    "Profile",
                    "Account management",
                    "Two-step verification",
                    "Remove account",
                    "Delete account"
                )
            )
        }

        item {
            SettingsSection(
                title = "Privacy",
                items = listOf(
                    "Password & Security",
                    "Change password",
                    "Saved login",
                    "Login alerts"
                )
            )
        }

        item {
            NotificationSettingsSection()
        }

        item {
            SettingsSection(
                title = "Subscriptions",
                items = listOf("Manage subscriptions")
            )
        }
    }
}
