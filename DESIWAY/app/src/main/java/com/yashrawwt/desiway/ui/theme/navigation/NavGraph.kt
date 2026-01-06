package com.yashrawwt.desiway.ui.theme.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yashrawwt.desiway.ui.theme.screens.adventure.AdventureDetailScreen
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

    const val FOOD_DETAIL = "food_detail"
    const val PLACE_DETAIL = "place_detail"
    const val ADVENTURE_DETAIL = "adventure_detail"
    const val STATE_DETAIL = "state_detail"
}


/* ---------------- NAV GRAPH ---------------- */

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
            ) + fadeIn()
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300)
            ) + fadeOut()
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300)
            ) + fadeIn()
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            ) + fadeOut()
        }
    ) {

        /* ---------- BOTTOM NAV ---------- */

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

        /* ---------- FEATURES ---------- */

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

        composable("${FeatureRoutes.FOOD_DETAIL}/{foodId}") {
            val foodId = it.arguments?.getString("foodId") ?: return@composable
            FoodDetailsScreen(foodId)
        }

        composable(FeatureRoutes.TRAVEL) {
            TravelScreen(navController)
        }

        composable(FeatureRoutes.ADVENTURE) {
            AdventureScreen(navController)
        }

        composable("${FeatureRoutes.ADVENTURE}/{adventureId}") {
            val id = it.arguments?.getString("adventureId") ?: return@composable
            AdventureDetailScreen(id)
        }

        composable(FeatureRoutes.CULTURE) {
            CultureScreen(navController)
        }

        composable("${FeatureRoutes.STATE_DETAIL}/{stateId}") {
            val stateId = it.arguments?.getString("stateId") ?: return@composable
            StateDetailScreen(stateId = stateId)
        }

        composable("${FeatureRoutes.PLACE_DETAIL}/{placeId}") {
            val placeId = it.arguments?.getString("placeId") ?: return@composable
            PlaceDetailScreen(placeId)
        }

        composable(FeatureRoutes.MAPS) {
            MapsScreen()
        }
    }
}
