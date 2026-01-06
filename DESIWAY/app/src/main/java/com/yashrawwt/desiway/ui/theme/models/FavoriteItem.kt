package com.yashrawwt.desiway.ui.theme.models

enum class FavoriteType {
    PLACE,
    FOOD,
    ADVENTURE
}

data class FavoriteItem(
    val id: String,
    val type: FavoriteType
)
