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
import com.yashrawwt.desiway.ui.theme.data.CultureRepository
import com.yashrawwt.desiway.ui.theme.models.CultureRegion
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

@Composable
fun CultureScreen(navController: NavHostController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(MustardTop, MustardBottom))),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {

        item { CultureHeader() }

        CultureRegion.values().forEach { region ->
            val states = CultureRepository.states.filter { it.region == region }

            if (states.isNotEmpty()) {
                item {
                    CultureSection(
                        title = region.name.replace("_", " "),
                        states = states,
                        navController = navController
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.height(40.dp)) }
    }
}

@Composable
private fun CultureHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text("Culture", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)
            Spacer(Modifier.height(12.dp))
            Text("Want to know about the culture")
            Text("Lets make you INDIAN 🙏")
        }

        AsyncImage(
            model = "https://i.pravatar.cc/150?img=12",
            contentDescription = null,
            modifier = Modifier.size(46.dp).clip(CircleShape)
        )
    }
}

@Composable
private fun CultureSection(
    title: String,
    states: List<com.yashrawwt.desiway.ui.theme.models.CultureState>,
    navController: NavHostController
) {

    Column {
        Text(title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 20.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(states.size) { index ->
                val state = states[index]

                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(220.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            navController.navigate("${FeatureRoutes.STATE_DETAIL}/${state.id}")
                        }
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
                            .background(Color.Black.copy(0.55f))
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(state.name, color = Color.White)
                    }
                }
            }
        }
    }
}
