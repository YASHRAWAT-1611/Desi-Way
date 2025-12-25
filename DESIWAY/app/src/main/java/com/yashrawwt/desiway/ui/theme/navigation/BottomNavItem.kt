package com.yashrawwt.desiway.ui.theme.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home
    )
    object Saved : BottomNavItem(
        route = "saved",
        title = "Saved",
        icon = Icons.Filled.Favorite
    )
    object Profile : BottomNavItem(
        route = "profile",
        title = "Profile",
        icon = Icons.Filled.Person
    )
    object Settings : BottomNavItem(
        route = "settings",
        title = "Settings",
        icon = Icons.Filled.Settings
    )
}