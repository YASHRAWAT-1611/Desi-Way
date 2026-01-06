package com.yashrawwt.desiway.ui.theme.data

import com.yashrawwt.desiway.ui.theme.models.Adventure
import com.yashrawwt.desiway.ui.theme.models.AdventureCategory

object AdventureRepository {

    val adventures = listOf(

        Adventure(
            id = "trek",
            name = "Trekking",
            location = "Ladakh, Uttarakhand, West Bengal",
            image = "https://images.unsplash.com/photo-1526772662000-3f88f10405ff",
            difficulty = "Moderate – Hard",
            duration = "5–10 Days",
            description = "India offers world-class trekking routes like Chadar Trek, Roopkund, and Sandakphu. These treks combine adventure, culture, and breathtaking Himalayan landscapes.",
            category = AdventureCategory.LAND
        ),

        Adventure(
            id = "para",
            name = "Paragliding",
            location = "Bir Billing, Himachal Pradesh",
            image = "https://images.unsplash.com/photo-1719949122509-74d0a1d08b44",
            difficulty = "Easy – Moderate",
            duration = "15–30 Minutes",
            description = "Bir Billing is among the top paragliding destinations in the world, offering high-altitude flights with panoramic views of the Himalayas.",
            category = AdventureCategory.AIR
        ),

        Adventure(
            id = "rafting_rishikesh",
            name = "River Rafting",
            location = "Rishikesh, Uttarakhand",
            image = "https://images.unsplash.com/photo-1685550903259-96799741df9e",
            difficulty = "Moderate",
            duration = "2–4 Hours",
            description = "White water rafting in Rishikesh is a thrilling experience on the Ganges, suitable for both beginners and professionals.",
            category = AdventureCategory.WATER
        ),

        Adventure(
            id = "ski",
            name = "Skiing",
            location = "Auli, Gulmarg",
            image = "https://images.unsplash.com/photo-1565992441121-4367c2967103",
            difficulty = "Moderate – Hard",
            duration = "Half / Full Day",
            description = "Skiing in India is best experienced in Auli and Gulmarg, known for their pristine snow slopes and professional facilities.",
            category = AdventureCategory.SNOW
        )
    )

    fun getAdventureById(id: String): Adventure? =
        adventures.find { it.id == id }
}
