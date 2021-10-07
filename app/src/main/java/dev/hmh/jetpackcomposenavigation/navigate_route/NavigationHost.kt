package dev.hmh.jetpackcomposenavigation.navigate_route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import dev.hmh.jetpackcomposenavigation.navigate_route.destination.Destinations

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
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
            Screen2(newText)
        }

        /*composable(
            Destinations.Screen2.route
        ) { args ->
            val newText = args.arguments?.getString("newText")
            Screen2(newText!!)
        }*/
    }
}