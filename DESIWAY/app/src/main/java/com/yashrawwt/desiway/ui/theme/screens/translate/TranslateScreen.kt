package com.yashrawwt.desiway.ui.theme.screens.translate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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

/* ---------------- MAIN SCREEN ---------------- */

@Composable
fun TranslateScreen() {

    var visible by remember { mutableStateOf(false) }
    var inputText by rememberSaveable { mutableStateOf("") }
    var translatedText by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(Unit) { visible = true }

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
                enter = fadeIn(animationSpec = tween(400))
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                ) {

                    TranslateHeader()

                    TranslateCard(
                        title = "Local Language of India",
                        text = inputText,
                        placeholder = "Write it here or open mic or click the picture of text",
                        onTextChange = {
                            inputText = it
                            translatedText = fakeTranslate(it)
                        }
                    )

                    TranslateCard(
                        title = "User Language",
                        text = translatedText,
                        placeholder = "Result",
                        readOnly = true
                    )

                    Spacer(Modifier.height(30.dp))
                }
            }
        }
    }
}

/* ---------------- HEADER ---------------- */

@Composable
private fun TranslateHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {

        Column {
            Text(
                text = "Translate",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)

            Spacer(Modifier.height(10.dp))

            Text(
                text = "Don’t understand anything",
                fontWeight = FontWeight.SemiBold
            )
            Text("We are here for you")
        }

        AsyncImage(
            model = "https://i.pravatar.cc/150?img=12",
            contentDescription = null,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
    }
}

/* ---------------- TRANSLATE CARD ---------------- */

@Composable
private fun TranslateCard(
    title: String,
    text: String,
    placeholder: String,
    readOnly: Boolean = false,
    onTextChange: (String) -> Unit = {}
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(title, fontWeight = FontWeight.Bold)

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Icon(
                    imageVector = Icons.Default.Mic,
                    contentDescription = "Mic",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { /* future voice input */ }
                )
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Camera",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { /* future OCR */ }
                )
            }
        }

        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            placeholder = { Text(placeholder) },
            shape = RoundedCornerShape(16.dp),
            readOnly = readOnly,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Black
            )
        )
    }
}

/* ---------------- DUMMY TRANSLATION LOGIC ---------------- */

/**
 * Temporary local translator.
 * Replace later with:
 * - ML Kit
 * - Google Translate API
 */
private fun fakeTranslate(input: String): String {
    if (input.isBlank()) return ""

    return when {
        input.contains("namaste", true) -> "Hello"
        input.contains("dhanyavaad", true) -> "Thank you"
        input.contains("paani", true) -> "Water"
        else -> "Translated: $input"
    }
}
