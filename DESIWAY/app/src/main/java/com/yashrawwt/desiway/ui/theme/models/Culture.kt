package com.yashrawwt.desiway.ui.theme.models

data class CultureState(
    val id: String,
    val name: String,
    val image: String,
    val region: CultureRegion
)

enum class CultureRegion {
    NORTH_INDIA,
    SOUTH_INDIA,
    WEST_INDIA,
    EAST_INDIA,
    NORTHEAST_INDIA,
    CENTRAL_INDIA
}
