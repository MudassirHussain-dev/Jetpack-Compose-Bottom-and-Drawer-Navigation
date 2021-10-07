package dev.hmh.jetpackcomposenavigation.navigation.bottum_nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import dev.hmh.jetpackcomposenavigation.navigation.screens.Screen3
import dev.hmh.jetpackcomposenavigation.navigation.screens.Screen1
import dev.hmh.jetpackcomposenavigation.navigation.screens.Screen2

@Composable
fun NavigationHost(
    navController: NavHostController,
    darkMode: MutableState<Boolean>
) {

    NavHost(navController = navController, startDestination = Destinations.Screen1.route) {
        composable(Destinations.Screen1.route) {
            Screen1(
                naveToScreen2 = {
                    navController.navigate(Destinations.Screen2.createRoute(it))
                }
            )
        }
        composable(
            Destinations.Screen2.route,
            arguments = listOf(navArgument("newText") { defaultValue = "Screen 2" })
        ) { args ->
            val newText = args.arguments?.getString("newText")
            requireNotNull(newText)
            Screen2(newText, darkMode = darkMode)
        }

        composable(
            Destinations.Screen3.route
        ) {
            Screen3()
        }

        /*composable(
            Destinations.Screen2.route
        ) { args ->
            val newText = args.arguments?.getString("newText")
            Screen2(newText!!)
        }*/
    }
}