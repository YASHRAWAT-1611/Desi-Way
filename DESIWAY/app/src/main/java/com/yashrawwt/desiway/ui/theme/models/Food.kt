package com.yashrawwt.desiway.ui.theme.models

enum class FoodCategory {
    VEGETARIAN,
    NON_VEGETARIAN,
    FAST_FOOD,
    DRINKS
}

data class Food(
    val id: String,
    val name: String,
    val image: String,
    val isVeg: Boolean,
    val category: FoodCategory
)
