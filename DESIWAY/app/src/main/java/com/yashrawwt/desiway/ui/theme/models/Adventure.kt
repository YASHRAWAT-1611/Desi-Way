package com.yashrawwt.desiway.ui.theme.models

data class Adventure(
    val id: String,
    val name: String,
    val image: String,
    val location: String,
    val difficulty: String,
    val duration: String,
    val description: String,
    val category: AdventureCategory
)

enum class AdventureCategory {
    LAND, AIR, WATER, SNOW
}
