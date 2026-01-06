package com.yashrawwt.desiway.ui.theme.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(){
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        value = query,
        onValueChange = {query = it},
        placeholder = { Text("Search places, food, help..")},
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null)},
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .padding(horizontal = 20.dp),
        shape = MaterialTheme.shapes.large
    )
}