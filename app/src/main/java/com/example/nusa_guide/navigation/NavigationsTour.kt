package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.screen.FavoritScreen
import com.example.nusa_guide.screen.HalamanBottom
import com.example.nusa_guide.screen.HomeScreen
import com.example.nusa_guide.screen.LoginScreen
import com.example.nusa_guide.screen.OnBoardingScreen
import com.example.nusa_guide.screen.OnBoardingScreen2
import com.example.nusa_guide.screen.ProfilScreen
import com.example.nusa_guide.screen.RegisterScreen
import com.example.nusa_guide.screen.RiwayatScreen
import com.example.nusa_guide.screen.SplashScreen

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
        composable(NavigationTourScreen.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(NavigationTourScreen.RegisterScreen.name) {
            RegisterScreen(navController = navController)
        }
        composable(NavigationTourScreen.HalamanBottom.name) {
            HalamanBottom()
        }
        composable(NavigationTourScreen.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(NavigationTourScreen.FavoritScreen.name) {
            FavoritScreen(navController)
        }
        composable(NavigationTourScreen.RiwayatScreen.name) {
            RiwayatScreen(navController)
        }
        composable(NavigationTourScreen.ProfilScreen.name) {
            ProfilScreen(navController)
        }
    }
}