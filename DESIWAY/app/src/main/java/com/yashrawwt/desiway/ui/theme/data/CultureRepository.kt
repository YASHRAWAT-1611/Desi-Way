package com.yashrawwt.desiway.ui.theme.data

import com.yashrawwt.desiway.ui.theme.models.CultureRegion
import com.yashrawwt.desiway.ui.theme.models.CultureState

object CultureRepository {

    val states = listOf(

        // -------- NORTH INDIA --------
        CultureState("uttarakhand", "Uttarakhand",
            "https://images.unsplash.com/photo-1743750176709-b46a3b10fdf6?q=80&w=736&auto=format&fit=crop",
            CultureRegion.NORTH_INDIA),

        CultureState("jammu_kashmir", "Jammu & Kashmir",
            "https://images.unsplash.com/photo-1755499236596-1317c74d52ab?q=80&w=1974&auto=format&fit=crop",
            CultureRegion.NORTH_INDIA),

        CultureState("ladakh", "Ladakh",
            "https://images.unsplash.com/photo-1748943955018-1592bf0bcf51?q=80&w=774&auto=format&fit=crop",
            CultureRegion.NORTH_INDIA),

        CultureState("himachal", "Himanchal Pardesh",
            "https://images.unsplash.com/photo-1727077095741-4129ba4e0bb4?q=80&w=687&auto=format&fit=crop",
            CultureRegion.NORTH_INDIA),

        CultureState("punjab", "Punjab",
            "https://images.unsplash.com/photo-1554772593-cc0206eee02b?q=80&w=687&auto=format&fit=crop",
            CultureRegion.NORTH_INDIA),

        CultureState("haryana", "Haryana",
            "https://images.unsplash.com/photo-1574929751963-9c6181261276?q=80&w=648&auto=format&fit=crop",
            CultureRegion.NORTH_INDIA),

        // -------- SOUTH INDIA --------
        CultureState("tamil_nadu", "Tamil Nadu",
            "https://plus.unsplash.com/premium_photo-1689838027426-bf5cc3a0131f?q=80&w=687&auto=format&fit=crop",
            CultureRegion.SOUTH_INDIA),

        CultureState("kerala", "Kerala",
            "https://images.unsplash.com/photo-1597735881932-d9664c9bbcea?q=80&w=683&auto=format&fit=crop",
            CultureRegion.SOUTH_INDIA),

        CultureState("karnataka", "Karnataka",
            "https://images.unsplash.com/photo-1631714712922-eaa39e4452fa?q=80&w=1170&auto=format&fit=crop",
            CultureRegion.SOUTH_INDIA),

        // -------- WEST INDIA --------
        CultureState("rajasthan", "Rajasthan",
            "https://plus.unsplash.com/premium_photo-1661962428918-6a57ab674e23?q=80&w=1170&auto=format&fit=crop",
            CultureRegion.WEST_INDIA),

        CultureState("gujarat", "Gujarat",
            "https://images.unsplash.com/photo-1604216958967-ee0ec1dd9b64?q=80&w=1170&auto=format&fit=crop",
            CultureRegion.WEST_INDIA),

        CultureState("maharashtra", "Maharashtra",
            "https://images.unsplash.com/photo-1701111574830-f29cffe931d6?q=80&w=687&auto=format&fit=crop",
            CultureRegion.WEST_INDIA),

        // -------- EAST INDIA --------
        CultureState("west_bengal", "West Bengal",
            "https://plus.unsplash.com/premium_photo-1681483539443-50ced66c7f56?q=80&w=694&auto=format&fit=crop",
            CultureRegion.EAST_INDIA),

        CultureState("odisha", "Odisha",
            "https://images.unsplash.com/photo-1723879867060-71f585cdba32?q=80&w=1171&auto=format&fit=crop",
            CultureRegion.EAST_INDIA),

        // -------- NORTHEAST INDIA --------
        CultureState("assam", "Assam",
            "https://images.unsplash.com/photo-1759738093262-9333c22c6aec?w=600&auto=format&fit=crop",
            CultureRegion.NORTHEAST_INDIA),

        CultureState("meghalaya", "Meghalaya",
            "https://images.unsplash.com/photo-1552978534-9d01e1f91517?q=80&w=1170&auto=format&fit=crop",
            CultureRegion.NORTHEAST_INDIA),

        // -------- CENTRAL INDIA --------
        CultureState("delhi", "Delhi",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLTN70ISTWK9uRzFhOCZP4CvuWXscWBnNahQ&s",
            CultureRegion.CENTRAL_INDIA),

        CultureState("uttar_pradesh", "Uttar Pradesh",
            "https://www.holidify.com/images/cmsuploads/compressed/14188021593_f6d726f31b_b_20170829183831.jpg",
            CultureRegion.CENTRAL_INDIA)
    )

    fun getStateById(id: String): CultureState? =
        states.find { it.id == id }
}
