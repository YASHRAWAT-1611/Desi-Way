package com.yashrawwt.desiway.ui.theme.screens.scam

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop

private const val USD_RATE = 83.0 // INR → USD

@Composable
fun ScamAlertScreen() {

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    var product by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var scamResult by remember { mutableStateOf<String?>(null) }

    var inr by remember { mutableStateOf("") }
    val usd by remember(inr) {
        mutableStateOf(
            inr.toDoubleOrNull()?.let { String.format("%.2f", it / USD_RATE) }
        )
    }

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(listOf(MustardTop, MustardBottom))
                )
                .padding(padding)
        ) {

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(400)) + slideInVertically(tween(400)) { it / 2 }
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    /* ---------- HEADER ---------- */
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Scam Alert", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)
                            Spacer(Modifier.height(6.dp))
                            Text("Don't need to be get scammed !", style = MaterialTheme.typography.bodyMedium)
                            Text("Just check it here", style = MaterialTheme.typography.bodyMedium)
                        }

                        AsyncImage(
                            model = "https://i.pravatar.cc/150?img=12",
                            contentDescription = null,
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                        )
                    }

                    /* ---------- CHECK SCAM CARD ---------- */
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {

                            Text("Check Scam", fontWeight = FontWeight.Bold)

                            OutlinedTextField(
                                value = product,
                                onValueChange = { product = it },
                                placeholder = { Text("Product name") },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true
                            )

                            OutlinedTextField(
                                value = price,
                                onValueChange = { price = it },
                                placeholder = { Text("Price (₹)") },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true
                            )

                            Button(
                                onClick = {
                                    scamResult =
                                        if (price.toIntOrNull() != null && price.toInt() < 500)
                                            "Suspicious Price"
                                        else
                                            "Looks Safe"
                                },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp)
                            ) {
                                Text("Analyze Price")
                            }

                            scamResult?.let {
                                AssistChip(
                                    onClick = {},
                                    label = { Text(it) },
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = if (it.contains("Suspicious")) Color(0xFFFFE0E0) else Color(0xFFE6F4EA),
                                        labelColor = if (it.contains("Suspicious")) Color.Red else Color(0xFF2E7D32)
                                    )
                                )
                            }
                        }
                    }

                    /* ---------- CURRENCY CONVERTER ---------- */
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {

                            Text("Currency Converter", fontWeight = FontWeight.Bold)

                            OutlinedTextField(
                                value = inr,
                                onValueChange = { inr = it },
                                placeholder = { Text("Amount in ₹ INR") },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("USD ($)", fontWeight = FontWeight.Medium)
                                Text(usd ?: "--", fontWeight = FontWeight.Bold)
                            }

                            Text(
                                "Rate: 1 USD ≈ ₹83",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}
