package com.yashrawwt.desiway.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yashrawwt.desiway.ui.theme.screens.dashboard.DashboardScreen
import com.yashrawwt.desiway.ui.theme.screens.emergency.EmergencyScreen
import com.yashrawwt.desiway.ui.theme.screens.favourite.FavouriteScreen
import com.yashrawwt.desiway.ui.theme.screens.food.FoodScreen
import com.yashrawwt.desiway.ui.theme.screens.home.HomeScreen
import com.yashrawwt.desiway.ui.theme.screens.scam.ScamAlertScreen
import com.yashrawwt.desiway.ui.theme.screens.settings.SettingsScreen
import com.yashrawwt.desiway.ui.theme.screens.translate.TranslateScreen
import com.yashrawwt.desiway.ui.theme.navigation.FeatureRoutes

object FeatureRoutes {
    const val EMERGENCY = "feature_emergency"
    const val SCAM = "feature_scam"
    const val TRANSLATE = "feature_translate"
    const val FOOD = "feature_food"
    const val TRAVEL = "feature_travel"
    const val ADVENTURE = "feature_adventure"
    const val CULTURE = "feature_culture"
    const val MAPS = "feature_maps"
}

@Composable
fun AppNavGraph(navController: androidx.navigation.NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.Saved.route) {
            FavouriteScreen(navController)
        }
        composable(BottomNavItem.Profile.route) {
            DashboardScreen(navController)
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen(navController)
        }
        // Feature Screens
        composable(FeatureRoutes.EMERGENCY) {
            EmergencyScreen()
        }
        composable(FeatureRoutes.SCAM) {
            ScamAlertScreen()
        }
        composable(FeatureRoutes.TRANSLATE) {
            TranslateScreen()
        }
        composable(FeatureRoutes.FOOD) {
            FoodScreen()
        }
        /*
        composable(FeatureRoutes.TRAVEL) {
            TravelScreen()
        }
        composable(FeatureRoutes.ADVENTURE) {
            AdventureScreen()
        }
        composable(FeatureRoutes.CULTURE) {
            CultureScreen()
        }
        composable(FeatureRoutes.MAPS) {
            MapsScreen()
        }*/
    }
}
