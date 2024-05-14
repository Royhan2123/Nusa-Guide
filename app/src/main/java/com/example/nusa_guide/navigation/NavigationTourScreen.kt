package com.example.nusa_guide.navigation

enum class NavigationTourScreen {
    SplashScreen,
    OnBoardingScreen,
    OnBoardingScreen2;

    fun fromRoute(route:String?): NavigationTourScreen =
        when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            OnBoardingScreen.name -> OnBoardingScreen
            OnBoardingScreen2.name -> OnBoardingScreen2
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }

}