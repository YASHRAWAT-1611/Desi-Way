package com.yashrawwt.desiway.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yashrawwt.desiway.ui.theme.screens.adventure.AdventureScreen
import com.yashrawwt.desiway.ui.theme.screens.culture.CultureScreen
import com.yashrawwt.desiway.ui.theme.screens.culture.StateDetailScreen
import com.yashrawwt.desiway.ui.theme.screens.dashboard.DashboardScreen
import com.yashrawwt.desiway.ui.theme.screens.emergency.EmergencyScreen
import com.yashrawwt.desiway.ui.theme.screens.favourite.FavouriteScreen
import com.yashrawwt.desiway.ui.theme.screens.food.FoodDetailsScreen
import com.yashrawwt.desiway.ui.theme.screens.food.FoodScreen
import com.yashrawwt.desiway.ui.theme.screens.home.HomeScreen
import com.yashrawwt.desiway.ui.theme.screens.maps.MapsScreen
import com.yashrawwt.desiway.ui.theme.screens.place.PlaceDetailScreen
import com.yashrawwt.desiway.ui.theme.screens.scam.ScamAlertScreen
import com.yashrawwt.desiway.ui.theme.screens.settings.SettingsScreen
import com.yashrawwt.desiway.ui.theme.screens.translate.TranslateScreen
import com.yashrawwt.desiway.ui.theme.screens.travel.TravelScreen

/* ---------------- FEATURE ROUTES ---------------- */

object FeatureRoutes {
    const val EMERGENCY = "feature_emergency"
    const val SCAM = "feature_scam"
    const val TRANSLATE = "feature_translate"
    const val FOOD = "feature_food"
    const val TRAVEL = "feature_travel"
    const val ADVENTURE = "feature_adventure"
    const val CULTURE = "feature_culture"
    const val MAPS = "feature_maps"

    // Culture → State Detail
    const val STATE_DETAIL = "state_detail"

    // Food → Food Detail
    const val FOOD_DETAIL = "food_detail"

    // Place → Place Detail
    const val PLACE_DETAIL = "place_detail"
}

/* ---------------- NAV GRAPH ---------------- */

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {

        /* ---------- BOTTOM NAV SCREENS ---------- */

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

        /* ---------- FEATURE SCREENS ---------- */

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
            FoodScreen(navController)
        }

        /* ---------- FOOD DETAIL (FOOD) ---------- */

        composable(
            route = "${FeatureRoutes.FOOD_DETAIL}/{foodId}"
        ) { backStackEntry ->
            val foodId = backStackEntry.arguments?.getString("foodId") ?: ""
            FoodDetailsScreen(foodId = foodId)
        }


        composable(FeatureRoutes.TRAVEL) {
            TravelScreen(navController)
        }

        composable(FeatureRoutes.ADVENTURE) {
            AdventureScreen()
        }

        composable(FeatureRoutes.CULTURE) {
            CultureScreen(navController)
        }

        /* ---------- STATE DETAIL (CULTURE) ---------- */

        composable(
            route = "${FeatureRoutes.STATE_DETAIL}/{stateName}"
        ) { backStackEntry ->
            val stateName =
                backStackEntry.arguments?.getString("stateName") ?: ""

            StateDetailScreen(stateName = stateName)
        }

        composable(FeatureRoutes.MAPS) {
            MapsScreen()
        }

        /* ---------- PLACE DETAIL (HOME SCREEN/FAVORITE/DASHBOARD) ---------- */

        composable(
            route = "${FeatureRoutes.PLACE_DETAIL}/{placeId}"
        ) { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId") ?: ""
            PlaceDetailScreen(placeId)
        }

    }
}
