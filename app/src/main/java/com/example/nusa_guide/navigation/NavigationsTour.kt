package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.screen.AboutProfileScreen
import com.example.nusa_guide.screen.CartScreen
import com.example.nusa_guide.screen.ChangePasswordSuccessScreen
import com.example.nusa_guide.screen.FavoriteScreen
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
import com.example.nusa_guide.screen.SearchScreen
import com.example.nusa_guide.screen.SplashScreen
import com.example.nusa_guide.screen.TransactionSuccessScreen
import com.example.nusa_guide.screen.VerificationCodeScreen
import com.example.nusa_guide.screen.cameraX.CameraXScreen
import com.example.nusa_guide.screen.detail_screen.DetailScreen

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
            HalamanBottom(navController)
        }
        composable(NavigationTourScreen.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(NavigationTourScreen.FavoriteScreen.name) {
            FavoriteScreen(navController)
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
            RekomendasiScreen(navController)
        }
        composable(NavigationTourScreen.AboutProfileScreen.name) {
            AboutProfileScreen(navController)
        }

        composable(NavigationTourScreen.FilteringScreen.name) {
            FilteringScreen(navController)
        }

        composable(NavigationTourScreen.CameraXScreen.name) {
            CameraXScreen(navController)
        }

        composable(NavigationTourScreen.DetailScreen.name) {
            DetailScreen(navController)
        }
        composable(NavigationTourScreen.CartScreen.name) {
            CartScreen(navController = navController)
        }
        composable(NavigationTourScreen.TransactionSuccessScreen.name) {
            TransactionSuccessScreen(navController = navController)
        }
    }
}
