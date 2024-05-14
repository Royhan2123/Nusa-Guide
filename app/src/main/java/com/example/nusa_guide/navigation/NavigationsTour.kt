package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.page.OnBoardingScreen
import com.example.nusa_guide.page.OnBoardingScreen2
import com.example.nusa_guide.page.SplashScreen

@Composable
fun NavigationsTour() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationTourScreen.SplashScreen.name
    ) {
        composable(NavigationTourScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationTourScreen.OnBoardingScreen.name) {
            OnBoardingScreen(navController = navController)
        }
        composable(NavigationTourScreen.OnBoardingScreen2.name) {
            OnBoardingScreen2(navController = navController)
        }
    }

}