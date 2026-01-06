package com.yashrawwt.desiway.ui.theme.screens.food

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop
import com.yashrawwt.desiway.ui.theme.data.FoodRepository
import com.yashrawwt.desiway.ui.theme.models.Food

@Composable
fun FoodDetailsScreen(foodId: String) {

    val food = FoodRepository.getFoodById(foodId)

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(listOf(MustardTop, MustardBottom))
                )
                .padding(padding)
        ) {

            food?.let {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    AsyncImage(
                        model = it.image,
                        contentDescription = it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = foodDescription(it),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray
                    )

                    AssistChip(
                        onClick = {},
                        label = {
                            Text(
                                if (it.isVeg) "Vegetarian 🌱" else "Non-Vegetarian 🍗"
                            )
                        }
                    )
                }

            } ?: run {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Food item not found")
                }
            }
        }
    }
}

/* ---------------- DESCRIPTION ---------------- */

private fun foodDescription(food: Food): String {
    return when (food.name) {
        "Rajma Chawal" -> "Rājmā, also known as rajmah, rāzmā, or lal lobia, is a vegetarian dish, originating from the Indian subcontinent, consisting of red kidney beans in a thick gravy with many Indian whole spices, and is usually served with rice. It is a part of the regular diet in Northern India, Nepal and Punjab province of Pakistan."
        "Masala Dosa" -> "Masala dosa is a dish of South India, consisting of a savoury dosa crepe stuffed with potato curry. It is a popular breakfast item in South India, though it can be served at all times of the day and found in many other parts of the country and overseas."
        "Paneer Tikka" -> "Paneer tikka masala is an Indian dish of paneer tikka cheese served in a spiced gravy. It is a vegetarian alternative to chicken tikka masala."
        "Chicken Curry" -> "Chicken curry or curry/curried chicken is a South Asian dish originating from the Indian subcontinent. It is common in the cuisine of the Indian subcontinent, Caribbean, Southeast Asia, Great Britain, and South Africa."
        "Fish Curry" -> "Fish curry is a versatile dish with many regional variations, commonly featuring fish in a spiced sauce or gravy and often served with rice or naan. You can find various recipes, from a quick 30-minute version to ready-to-eat options and specific regional styles like the spicy Kerala fish curry or a coconut-based curry. "
        "Butter Chicken" -> "Butter chicken, or murgh makhani, is a globally popular Indian curry featuring marinated chicken in a rich, creamy, and mildly spiced tomato and butter-based gravy. Originating in Delhi in the 1950s at the Moti Mahal restaurant, it is known for its smooth texture and vibrant orange-red color. "
        "Samosa" -> "A samosa is a popular fried or baked South Asian pastry with a savory filling, typically spiced potatoes, onions, and peas. It is a beloved street food, snack, or appetizer enjoyed across many parts of the world, often served hot with chutneys. "
        "Pani Puri" -> "Pani Puri, also known as Golgappa or Phuchka in various regions, is a beloved Indian street food snack that offers a burst of spicy, tangy, and sweet flavors in a single bite. It consists of crispy, hollow fried dough balls (puris) filled with a mixture of ingredients and flavored water. "
        "Chowmein" -> "Chow mein is a classic Chinese dish of stir-fried noodles combined with vegetables, protein (such as chicken, beef, or tofu), and a savory sauce. It is popular worldwide and has many regional variations, including a prominent Indo-Chinese style. "
        "Masala Chai" -> "Masala chai (or Indian spiced tea) is a popular, flavorful, and aromatic beverage from India made by brewing black tea with a mixture of aromatic herbs and spices, milk, and a sweetener. The term \"chai\" means \"tea\" in Hindi, so calling it \"chai tea\" is redundant. "
        "Lassi" -> "Lassi is a popular, creamy, yogurt-based Indian drink, originating from Punjab, made by blending yogurt with water, spices, and sometimes fruit, offering sweet (with sugar, mango, cardamom) or savory (with salt, cumin) versions, known for its cooling effect and probiotics that aid digestion, perfect for hot weather. "
        "Sugarcane Juice" -> "Sugarcane juice is the liquid extracted from pressed sugarcane. It is consumed as a beverage in many places, especially where sugarcane is commercially grown, such as Southeast Asia, the Indian subcontinent, North Africa, mainly Egypt, and also in South America, especially Brazil."
        else -> "A delicious Indian dish loved by everyone."
    }
}
