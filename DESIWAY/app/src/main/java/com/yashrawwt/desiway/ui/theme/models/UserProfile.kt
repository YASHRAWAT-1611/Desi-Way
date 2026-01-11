package com.yashrawwt.desiway.ui.theme.models

data class UserStats(
    val distance: Int = 0,
    val states: Int = 0,
    val trips: Int = 0
)

data class UserSettings(
    val notifications: Boolean = true,
    val darkMode: Boolean = false,
    val language: String = "en"
)

data class UserProfile(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val photoUrl: String = "",
    val stats: UserStats = UserStats(),
    val settings: UserSettings = UserSettings()
)
