package com.yashrawwt.desiway.ui.theme.screens.adventure

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

/* ---------------- MAIN SCREEN ---------------- */

@Composable
fun AdventureScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(MustardTop, MustardBottom))
            ),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {

        item { AdventureHeader() }

        item {
            AdventureSection(
                title = "Land Adventures",
                activities = landAdventures
            )
        }

        item {
            AdventureSection(
                title = "Air Adventures",
                activities = airAdventures
            )
        }

        item {
            AdventureSection(
                title = "Water Adventures",
                activities = waterAdventures
            )
        }

        item {
            AdventureSection(
                title = "Snow Adventures",
                activities = snowAdventures
            )
        }

        item { AdventureTips() }

        item { Spacer(modifier = Modifier.height(40.dp)) }
    }
}

/* ---------------- HEADER ---------------- */

@Composable
private fun AdventureHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {

        Column {
            Text(
                text = "Adventure",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)

            Spacer(Modifier.height(12.dp))

            Text(
                text = "Ready to unleash your inner",
                fontWeight = FontWeight.SemiBold
            )
            Text("adventurer?")
        }

        AsyncImage(
            model = "https://i.pravatar.cc/150?img=12",
            contentDescription = null,
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

/* ---------------- SECTION ---------------- */

@Composable
private fun AdventureSection(
    title: String,
    activities: List<AdventureItem>
) {
    Column {

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(activities.size) { index ->
                AdventureCard(item = activities[index])
            }
        }
    }
}

/* ---------------- CARD ---------------- */

@Composable
private fun AdventureCard(item: AdventureItem) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {

        AsyncImage(
            model = item.image,
            contentDescription = item.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.55f))
                .padding(vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = item.title,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/* ---------------- TIPS ---------------- */

@Composable
private fun AdventureTips() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "Tips for Adventure in India",
            fontWeight = FontWeight.Bold
        )

        TipItem("Safety", "Always use certified operators, wear safety gear and follow guides.")
        TipItem("Age & Fitness", "Check age limits and physical difficulty before booking.")
        TipItem("Best Time", "Activity seasons vary (e.g. winter for snow sports, Oct–Feb for Goa).")
    }
}

@Composable
private fun TipItem(title: String, description: String) {
    Column {
        Text(title, fontWeight = FontWeight.SemiBold)
        Text(description, style = MaterialTheme.typography.bodySmall)
    }
}

/* ---------------- DATA MODEL ---------------- */

data class AdventureItem(
    val id: String,
    val title: String,
    val image: String
)

/* ---------------- DATA ---------------- */

private val landAdventures = listOf(
    AdventureItem("trek", "Trekking",
        "https://images.unsplash.com/photo-1526772662000-3f88f10405ff?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("bike", "Mountain Biking",
        "https://images.unsplash.com/photo-1575548393466-0df1618ba410?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("safari", "Wildlife Safari",
        "https://plus.unsplash.com/premium_photo-1661895052895-c7163da980cc?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("caving", "Caving",
        "https://images.unsplash.com/photo-1638793772937-be3aca02531f?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("atv", "ATV / Off-Roading",
        "https://images.unsplash.com/photo-1707572547245-343865235775?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
)

private val airAdventures = listOf(
    AdventureItem("para", "Paragliding",
        "https://images.unsplash.com/photo-1719949122509-74d0a1d08b44?q=80&w=736&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("bungee", "Bungee Jumping",
        "https://images.unsplash.com/photo-1559677624-3c956f10d431?q=80&w=1025&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("sky", "Skydiving",
        "https://images.unsplash.com/photo-1675645294783-8ae8e106a03a?q=80&w=710&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("balloon", "Hot Air Balloon",
        "https://images.unsplash.com/photo-1517520267752-34bfde704a0f?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
)

private val waterAdventures = listOf(
    AdventureItem("rafting", "River Rafting",
        "https://images.unsplash.com/photo-1685550903259-96799741df9e?q=80&w=1146&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("scuba", "Scuba Diving",
        "https://images.unsplash.com/photo-1544551763-46a013bb70d5?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("surf", "Surfing",
        "https://images.unsplash.com/photo-1609870025624-98b62826e80a?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("kayak", "Kayaking",
        "https://images.unsplash.com/photo-1480480565647-1c4385c7c0bf?q=80&w=1331&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
)

private val snowAdventures = listOf(
    AdventureItem("ski", "Skiing",
        "https://images.unsplash.com/photo-1565992441121-4367c2967103?q=80&w=2023&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    AdventureItem("snowboard", "Snowboarding",
        "https://images.unsplash.com/photo-1599405653894-8a595f692abf?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
)
