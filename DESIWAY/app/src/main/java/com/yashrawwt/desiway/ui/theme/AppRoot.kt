package com.yashrawwt.desiway.ui.theme

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.yashrawwt.desiway.ui.theme.data.AuthState
import com.yashrawwt.desiway.ui.theme.screens.auth.AuthNavGraph
import com.yashrawwt.desiway.ui.theme.screens.home.MainScreen

@Composable
fun AppRoot() {

    val navController = rememberNavController()
    val isLoggedIn by AuthState.isLoggedIn.collectAsState()

    if (isLoggedIn) {
        MainScreen()
    } else {
        AuthNavGraph(navController)
    }
}
