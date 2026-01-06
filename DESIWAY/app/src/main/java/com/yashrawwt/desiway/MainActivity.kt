package com.yashrawwt.desiway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.yashrawwt.desiway.ui.theme.DesiWayTheme
import com.yashrawwt.desiway.ui.theme.screens.home.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash screen
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        // Remove splash immediately (fast app feel)
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
private fun AppEntryAnimation(
    content: @Composable () -> Unit
) {
    var visible by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            animationSpec = tween(durationMillis = 450)
        ) + scaleIn(
            initialScale = 0.97f,
            animationSpec = tween(durationMillis = 450)
        )
    ) {
        content()
    }
}
