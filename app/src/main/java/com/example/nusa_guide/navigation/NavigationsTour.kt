package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.DummyData.paketPremiumList
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.screen.*
import com.example.nusa_guide.screen.detail_screen.DetailScreen

@Composable
fun NavigationsTour() {
    val navController = rememberNavController()

    val rekomendasiList = listOf(
        Rekomendasi(1, "Pantai Kuta", R.drawable.tour_image_1, 50000, 10),
        Rekomendasi(2, "Pura Besakih", R.drawable.tour_image_1, 75000, 25),
    )

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
        composable(NavigationTourScreen.ProfileScreen.name) {
            ProfileScreen(navController)
        }
        composable(NavigationTourScreen.ForgotPasswordScreen.name) {
            ForgotPasswordScreen(navController)
        }
        composable(NavigationTourScreen.ChangePasswordSuccessScreen.name) {
            ChangePasswordSuccessScreen(navController)
        }
        composable(NavigationTourScreen.VerificationCodeScreen.name) {
            VerificationCodeScreen(navController)
        }
        composable(NavigationTourScreen.SearchScreen.name) {
            SearchScreen(navController)
        }
        composable(NavigationTourScreen.RekomendasiScreen.name) {
            RekomendasiScreen(navController, rekomendasiList)
        }
        composable(NavigationTourScreen.PaketPremiumScreen.name) {
            PaketPremiumScreen(navController, paketPremiumList )
        }
        composable(NavigationTourScreen.AboutProfileScreen.name) {
            AboutProfileScreen()
        }
        composable(NavigationTourScreen.DetailScreen.name) {
            DetailScreen()
        }
    }
}
