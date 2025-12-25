package com.yashrawwt.desiway.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yashrawwt.desiway.ui.theme.screens.common.PlaceholderScreen
import com.yashrawwt.desiway.ui.theme.screens.home.HomeScreen

@Composable
fun AppNavGraph(navController: androidx.navigation.NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Saved.route) {
            PlaceholderScreen("Saved")
        }
        composable(BottomNavItem.Profile.route) {
            PlaceholderScreen("Profile")
        }
        composable(BottomNavItem.Settings.route) {
            PlaceholderScreen("Settings")
        }
    }
}
