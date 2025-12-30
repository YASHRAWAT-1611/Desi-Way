package com.yashrawwt.desiway.ui.theme.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yashrawwt.desiway.ui.theme.navigation.BottomNavItem

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Saved,
        BottomNavItem.Profile,
        BottomNavItem.Settings
    )

    NavigationBar(
        containerColor = Color.Black,
        tonalElevation = 0.dp
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->

            val selected = currentRoute == item.route

            // 🔥 subtle scale animation for active icon
            val scale by animateFloatAsState(
                targetValue = if (selected) 1.15f else 1f,
                label = "icon_scale"
            )

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(BottomNavItem.Home.route) {
                            inclusive = false
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(24.dp)
                            .shadow(
                                elevation = if (selected) 18.dp else 0.dp,
                                shape = MaterialTheme.shapes.small,
                                ambientColor = if (selected) Color(0xFF00FF66) else Color.Transparent,
                                spotColor = if (selected) Color(0xFF00FF66) else Color.Transparent
                            )
                            .then(Modifier.size((24 * scale).dp)),
                        tint = if (selected) Color(0xFF00FF66) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selected) Color(0xFF00FF66) else Color.Gray
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
