package com.yashrawwt.desiway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.yashrawwt.desiway.ui.theme.DesiWayTheme
import com.yashrawwt.desiway.ui.theme.screens.home.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        // Make splash screen disappear immediately
        splashScreen.setKeepOnScreenCondition { false }

        setContent {
            DesiWayTheme {
                AppEntryAnimation {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
private fun AppEntryAnimation(content: @Composable () -> Unit) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(500)) +
                scaleIn(
                    initialScale = 0.98f,
                    animationSpec = tween(500)
                )
    ) {
        content()
    }
}
