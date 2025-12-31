package com.yashrawwt.desiway.ui.theme.screens.culture

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

/* ---------------- MAIN SCREEN ---------------- */

@Composable
fun CultureScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(MustardTop, MustardBottom))
            ),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {

        item { CultureHeader() }

        cultureSections.forEach { section ->
            item {
                CultureSection(
                    title = section.title,
                    states = section.states,
                    navController = navController
                )
            }
        }

        item { Spacer(modifier = Modifier.height(40.dp)) }
    }
}


/* ---------------- HEADER ---------------- */

@Composable
private fun CultureHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {

        Column {
            Text(
                text = "Culture",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)

            Spacer(Modifier.height(12.dp))

            Text("Want to know about the culture")
            Text("Lets make you INDIAN 🙏")
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
private fun CultureSection(
    title: String,
    states: List<CultureState>,
    navController: NavHostController
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
            items(states.size) { index ->
                CultureCard(
                    state = states[index],
                    onClick = {
                        navController.navigate(
                            "${FeatureRoutes.STATE_DETAIL}/${states[index].name}"
                        )
                    }
                )
            }
        }
    }
}


/* ---------------- CARD ---------------- */

@Composable
private fun CultureCard(
    state: CultureState,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = state.image,
            contentDescription = state.name,
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
                text = state.name,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}


/* ---------------- DATA MODELS ---------------- */

data class CultureState(
    val name: String,
    val image: String
)

data class CultureSectionData(
    val title: String,
    val states: List<CultureState>
)

/* ---------------- DATA ---------------- */

private val cultureSections = listOf(

    CultureSectionData(
        "North India",
        listOf(
            CultureState("Uttarakhand", "https://images.unsplash.com/photo-1743750176709-b46a3b10fdf6?q=80&w=736&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Jammu & Kashmir", "https://images.unsplash.com/photo-1755499236596-1317c74d52ab?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Ladakh", "https://images.unsplash.com/photo-1748943955018-1592bf0bcf51?q=80&w=774&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Himanchal Pardesh", "https://images.unsplash.com/photo-1727077095741-4129ba4e0bb4?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Punjab", "https://images.unsplash.com/photo-1554772593-cc0206eee02b?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Chandigarh", "https://images.unsplash.com/photo-1588669494151-f4c6df6f715b?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Haryana", "https://images.unsplash.com/photo-1574929751963-9c6181261276?q=80&w=648&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
        )
    ),

    CultureSectionData(
        "South India",
        listOf(
            CultureState("Tamil Nadu", "https://plus.unsplash.com/premium_photo-1689838027426-bf5cc3a0131f?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Kerala", "https://images.unsplash.com/photo-1597735881932-d9664c9bbcea?q=80&w=683&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Karnataka", "https://images.unsplash.com/photo-1631714712922-eaa39e4452fa?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Andhra Pradesh", "https://images.unsplash.com/photo-1723816936495-9695a3571bb8?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Telangana", "https://images.unsplash.com/photo-1585607344846-8fcde8370442?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Punducherry", "https://plus.unsplash.com/premium_photo-1764533878594-466c1f92730b?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Lakshadweep", "https://images.unsplash.com/photo-1646130322178-c9d8da261891?q=80&w=1172&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
        )
    ),

    CultureSectionData(
        "West India",
        listOf(
            CultureState("Rajasthan", "https://plus.unsplash.com/premium_photo-1661962428918-6a57ab674e23?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Gujarat", "https://images.unsplash.com/photo-1604216958967-ee0ec1dd9b64?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Maharashtra", "https://images.unsplash.com/photo-1701111574830-f29cffe931d6?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Goa", "https://images.unsplash.com/photo-1496566084516-c5b96fcbd5c8?q=80&w=1172&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Dadra & Nagar Haveli", "https://s7ap1.scene7.com/is/image/incredibleindia/1-baps-swaminarayan-temple-silvassa-dadra-and-nagar-haveli-2-city-hero?qlt=82&ts=1726737660598"),
            CultureState("Daman & Diu", "https://www.adotrip.com/public/images/state/contentImg/5fc482055bc1f.jpg")
        )
    ),

    CultureSectionData(
        "East",
        listOf(
            CultureState("West Bengal", "https://plus.unsplash.com/premium_photo-1681483539443-50ced66c7f56?q=80&w=694&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Odisha", "https://images.unsplash.com/photo-1723879867060-71f585cdba32?q=80&w=1171&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Bihar", "https://images.unsplash.com/photo-1761711952374-ec7363ff6514?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Jharkhand", "https://plus.unsplash.com/premium_photo-1691031429261-aeb324882888?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
        )
    ),

    CultureSectionData(
        "Northeast",
        listOf(
            CultureState("Assam", "https://images.unsplash.com/photo-1759738093262-9333c22c6aec?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8QXNzYW1lc2UlMjBjdWx0dXJlfGVufDB8fDB8fHww"),
            CultureState("Arunachal Pradesh", "https://images.unsplash.com/photo-1764432235294-aa01a5fb8b83?q=80&w=735&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Manipur", "https://images.unsplash.com/photo-1720260990556-f72a4fdadbf3?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Meghalaya", "https://images.unsplash.com/photo-1552978534-9d01e1f91517?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            CultureState("Mizoram", "https://www.holidify.com/images/cmsuploads/articles/267.jpg"),
            CultureState("Nagaland", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzgjbwCmGyXuPLZa_pBbmydFuTmxHoRGh9IQ&s"),
            CultureState("Tripura", "https://www.darkgreenadventures.com/wp-content/uploads/2023/09/Tripura-Where-Culture-Meets-Nature-4.jpg"),
            CultureState("Sikkim", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlLEpB3HPouXQbMTR4HqhDg5sOvUIh135OVg&s"),
            CultureState("Andaman & Nicobar", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnuZC36beNIEie3vWhZehnugaFdCMlaM5Ldw&s")
        )
    ),

    CultureSectionData(
        "Central India",
        listOf(

            CultureState("Delhi", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLTN70ISTWK9uRzFhOCZP4CvuWXscWBnNahQ&s"),
            CultureState("Uttar Pradesh", "https://www.holidify.com/images/cmsuploads/compressed/14188021593_f6d726f31b_b_20170829183831.jpg"),
            CultureState("Madhya Pradesh", "https://banasri.in/wp-content/uploads/2024/06/Festivals-of-Madhya-Pradesh.jpg"),
            CultureState("Chhattisgarh", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY4GVxZAVhPlYQ2hbEPFoHJqKktzLqRzNs2w&s")
        )
    )
)
