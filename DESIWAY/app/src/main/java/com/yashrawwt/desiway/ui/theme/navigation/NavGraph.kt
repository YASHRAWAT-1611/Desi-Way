package com.yashrawwt.desiway.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yashrawwt.desiway.ui.theme.screens.dashboard.DashboardScreen
import com.yashrawwt.desiway.ui.theme.screens.favourite.FavouriteScreen
import com.yashrawwt.desiway.ui.theme.screens.home.HomeScreen
import com.yashrawwt.desiway.ui.theme.screens.settings.SettingsScreen

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
            FavouriteScreen()
        }
        composable(BottomNavItem.Profile.route) {
            DashboardScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }
    }
}
