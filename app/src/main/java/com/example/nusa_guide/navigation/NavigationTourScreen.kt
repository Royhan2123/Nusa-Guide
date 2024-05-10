package com.example.nusa_guide.navigation

enum class NavigationTourScreen {
    SplashScreen;

    fun fromRoute(route:String?): NavigationTourScreen =
        when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }

}