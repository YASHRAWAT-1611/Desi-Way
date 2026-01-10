package com.yashrawwt.desiway.ui.theme.screens.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

object AuthRoutes {
    const val LOGIN = "auth_login"
    const val REGISTER = "auth_register"
}

@Composable
fun AuthNavGraph(
    navController: NavHostController,
    onLogin: (String, String) -> Unit,
    onRegister: (String, String, String) -> Unit,
    onGoogleLogin: () -> Unit,
    onAuthSuccess: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoutes.LOGIN
    ) {

        composable(AuthRoutes.LOGIN) {
            LoginScreen(
                onLoginClick = { email, password ->
                    onLogin(email, password)
                },
                onGoogleClick = {
                    onGoogleLogin()
                },
                onRegisterClick = {
                    navController.navigate(AuthRoutes.REGISTER)
                }
            )
        }

        composable(AuthRoutes.REGISTER) {
            RegisterScreen(
                onRegisterClick = { name, email, password ->
                    onRegister(name, email, password)
                },
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
