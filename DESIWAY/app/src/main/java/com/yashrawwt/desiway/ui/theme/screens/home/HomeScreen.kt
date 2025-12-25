package com.yashrawwt.desiway.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.yashrawwt.desiway.ui.components.BottomNavigationBar
import com.yashrawwt.desiway.ui.theme.*
import com.yashrawwt.desiway.ui.theme.navigation.AppNavGraph

@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color.Transparent
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MustardYellow,
                            OrangeLight
                        )
                    )
                )
                .padding(padding)
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                HomeHeader()
                SearchBar()
                TopVisitsSection()
                FeatureGrid()
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            AppNavGraph(navController)
        }
    }
}