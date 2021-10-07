package dev.hmh.jetpackcomposenavigation.navigation.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import dev.hmh.jetpackcomposenavigation.navigation.bottum_nav.Destinations
import dev.hmh.jetpackcomposenavigation.navigation.currentRoute

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Destinations>
) {
    val currentRoute = currentRoute(navController)
    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false
            )

        }
    }
}

