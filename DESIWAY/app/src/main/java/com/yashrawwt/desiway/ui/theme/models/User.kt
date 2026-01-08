data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val photoUrl: String = "",
    val preferences: UserPreferences = UserPreferences()
)

data class UserPreferences(
    val darkMode: Boolean = false,
    val language: String = "en",
    val notifications: Boolean = true
)
