package com.yashrawwt.desiway.ui.theme.data

import com.yashrawwt.desiway.ui.theme.models.Food
import com.yashrawwt.desiway.ui.theme.models.FoodCategory

/**
 * Single source of truth for Food data
 * UI must never mutate this list directly
 */
object FoodRepository {

    /** Immutable list (good practice) */
    val foods: List<Food> = listOf(

        Food(
            id = "rajma_chawal",
            name = "Rajma Chawal",
            image = "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?q=80&w=735&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.VEGETARIAN
        ),

        Food(
            id = "masala_dosa",
            name = "Masala Dosa",
            image = "https://images.unsplash.com/photo-1694849789325-914b71ab4075?q=80&w=1074&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.VEGETARIAN
        ),

        Food(
            id = "paneer_tikka",
            name = "Paneer Tikka",
            image = "https://images.unsplash.com/photo-1631452180519-c014fe946bc7?q=80&w=687&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.VEGETARIAN
        ),

        Food(
            id = "chicken_curry",
            name = "Chicken Curry",
            image = "https://images.unsplash.com/photo-1694579740719-0e601c5d2437?q=80&w=1974&auto=format&fit=crop",
            isVeg = false,
            category = FoodCategory.NON_VEGETARIAN
        ),

        Food(
            id = "fish_curry",
            name = "Fish Curry",
            image = "https://images.unsplash.com/photo-1574484284002-952d92456975?q=80&w=687&auto=format&fit=crop",
            isVeg = false,
            category = FoodCategory.NON_VEGETARIAN
        ),

        Food(
            id = "butter_chicken",
            name = "Butter Chicken",
            image = "https://images.unsplash.com/photo-1728910107534-e04e261768ae?q=80&w=880&auto=format&fit=crop",
            isVeg = false,
            category = FoodCategory.NON_VEGETARIAN
        ),

        Food(
            id = "samosa",
            name = "Samosa",
            image = "https://images.unsplash.com/photo-1601050690597-df0568f70950?q=80&w=1170&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.FAST_FOOD
        ),

        Food(
            id = "pani_puri",
            name = "Pani Puri",
            image = "https://plus.unsplash.com/premium_photo-1691030658159-e8e29b2b12b9?q=80&w=687&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.FAST_FOOD
        ),

        Food(
            id = "chowmein",
            name = "Chowmein",
            image = "https://images.unsplash.com/photo-1617622141675-d3005b9067c5?q=80&w=764&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.FAST_FOOD
        ),

        Food(
            id = "masala_chai",
            name = "Masala Chai",
            image = "https://images.unsplash.com/photo-1633069683078-b180ba2afd89?q=80&w=735&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.DRINKS
        ),

        Food(
            id = "lassi",
            name = "Lassi",
            image = "https://images.unsplash.com/photo-1692620609860-be6717812f71?q=80&w=687&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.DRINKS
        ),

        Food(
            id = "sugarcane_juice",
            name = "Sugarcane Juice",
            image = "https://images.unsplash.com/photo-1534353473418-4cfa6c56fd38?q=80&w=687&auto=format&fit=crop",
            isVeg = true,
            category = FoodCategory.DRINKS
        )
    )

    /** Used by FoodDetailsScreen */
    fun getFoodById(id: String): Food? {
        return foods.firstOrNull { it.id == id }
    }

    /** Helper (optional but useful) */
    fun getFoodsByCategory(category: FoodCategory): List<Food> {
        return foods.filter { it.category == category }
    }
}
