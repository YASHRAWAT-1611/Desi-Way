package com.yashrawwt.desiway.ui.theme.screens.food

object FoodRepository {

    val allFood = listOf(
        FoodItemData("veg1", "Rajma Chawal",
            "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?q=80&w=735&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.VEGETARIAN),

        FoodItemData("veg2", "Masala Dosa",
            "https://images.unsplash.com/photo-1694849789325-914b71ab4075?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.VEGETARIAN),

        FoodItemData("veg2", "Paneer Tikka",
            "https://images.unsplash.com/photo-1631452180519-c014fe946bc7?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.VEGETARIAN),

        FoodItemData("non1", "Chicken Curry",
            "https://images.unsplash.com/photo-1694579740719-0e601c5d2437?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            false, FoodCategory.NON_VEGETARIAN),

        FoodItemData("non1", "Fish Curry",
            "https://images.unsplash.com/photo-1574484284002-952d92456975?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            false, FoodCategory.NON_VEGETARIAN),

        FoodItemData("non1", "Butter Chicken",
            "https://images.unsplash.com/photo-1728910107534-e04e261768ae?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            false, FoodCategory.NON_VEGETARIAN),

        FoodItemData("fast1", "Samosa",
            "https://images.unsplash.com/photo-1601050690597-df0568f70950?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.FAST_FOOD),

        FoodItemData("fast1", "Pani Puri",
            "https://plus.unsplash.com/premium_photo-1691030658159-e8e29b2b12b9?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.FAST_FOOD),

        FoodItemData("fast1", "Chowmein",
            "https://images.unsplash.com/photo-1617622141675-d3005b9067c5?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.FAST_FOOD),

        FoodItemData("drink1", "Masala Chai",
            "https://images.unsplash.com/photo-1633069683078-b180ba2afd89?q=80&w=735&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.DRINKS),

        FoodItemData("drink1", "Lassi",
            "https://images.unsplash.com/photo-1692620609860-be6717812f71?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.DRINKS),

        FoodItemData("drink1", "Sugarcane Juice",
            "https://images.unsplash.com/photo-1534353473418-4cfa6c56fd38?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            true, FoodCategory.DRINKS)
    )

    fun getFoodById(id: String): FoodItemData? {
        return allFood.find { it.id == id }
    }
}
