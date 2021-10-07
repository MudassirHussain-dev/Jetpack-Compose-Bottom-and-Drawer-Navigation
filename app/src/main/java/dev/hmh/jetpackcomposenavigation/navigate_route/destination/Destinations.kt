package dev.hmh.jetpackcomposenavigation.navigate_route.destination

sealed class Destinations(val route: String) {
    object Screen1 : Destinations("screen1")
 /*   object Screen2 : Destinations("screen2/{newText}") {
        fun createRoute(newText: String) = "screen2/$newText"
    }*/
 object Screen2 : Destinations("screen2/?newText={newText}") {
     fun createRoute(newText: String) = "screen2/?newText=$newText"
 }
}