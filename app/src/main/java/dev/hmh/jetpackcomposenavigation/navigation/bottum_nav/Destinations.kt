package dev.hmh.jetpackcomposenavigation.navigation.bottum_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Screen1 : Destinations("screen1", "Screen1", Icons.Filled.Home)

    /*   object Screen2 : Destinations("screen2/{newText}") {
           fun createRoute(newText: String) = "screen2/$newText"
       }*/
    object Screen2 : Destinations("screen2/?newText={newText}", "Screen2", Icons.Filled.Settings) {
        fun createRoute(newText: String) = "screen2/?newText=$newText"
    }

    object Screen3 : Destinations("screen3", "Screen3", Icons.Filled.Favorite)
}