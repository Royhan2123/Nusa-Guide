package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.screen.AboutProfileScreen
import com.example.nusa_guide.screen.ChangePasswordSuccessScreen
import com.example.nusa_guide.screen.FavoritScreen
import com.example.nusa_guide.screen.FilteringScreen
import com.example.nusa_guide.screen.ForgotPasswordScreen
import com.example.nusa_guide.screen.HalamanBottom
import com.example.nusa_guide.screen.HomeScreen
import com.example.nusa_guide.screen.LoginScreen
import com.example.nusa_guide.screen.OnBoardingScreen
import com.example.nusa_guide.screen.OnBoardingScreen2
import com.example.nusa_guide.screen.ProfileScreen
import com.example.nusa_guide.screen.RegisterScreen
import com.example.nusa_guide.screen.RekomendasiScreen
import com.example.nusa_guide.screen.RiwayatScreen
import com.example.nusa_guide.screen.SearchScreen
import com.example.nusa_guide.screen.SplashScreen
import com.example.nusa_guide.screen.UlasanScreen
import com.example.nusa_guide.screen.UlasanSuccesScreen
import com.example.nusa_guide.screen.VerificationCodeScreen
import com.example.nusa_guide.screen.cameraX.CameraXScreen

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
            RekomendasiScreen(navController, rekomendasiList)
        }
        composable(NavigationTourScreen.AboutProfileScreen.name) {
            AboutProfileScreen(navController)
        }
        composable(NavigationTourScreen.UlasanScreen.name) {
            UlasanScreen(navController)
        }
        composable(NavigationTourScreen.FilteringScreen.name) {
            FilteringScreen(navController)
        }
        composable(NavigationTourScreen.UlasanSuccesScreen.name) {
            UlasanSuccesScreen(navController)
        }
        composable(NavigationTourScreen.CameraXScreen.name) {
            CameraXScreen(navController)
        }
    }
}
