package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nusa_guide.screen.AboutProfileScreen
import com.example.nusa_guide.screen.CartScreen
import com.example.nusa_guide.screen.ChangePasswordSuccessScreen
import com.example.nusa_guide.screen.DetailScreen
import com.example.nusa_guide.screen.FavoriteScreen
import com.example.nusa_guide.screen.FilteringScreen
import com.example.nusa_guide.screen.ForgotPasswordScreen
import com.example.nusa_guide.screen.HalamanBottom
import com.example.nusa_guide.screen.LoginScreen
import com.example.nusa_guide.screen.OnBoardingScreen
import com.example.nusa_guide.screen.OnBoardingScreen2
import com.example.nusa_guide.screen.ProfileScreen
import com.example.nusa_guide.screen.RegisterScreen
import com.example.nusa_guide.screen.SearchScreen
import com.example.nusa_guide.screen.SplashScreen
import com.example.nusa_guide.screen.TransactionSuccessScreen

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
            HalamanBottom(navController = navController)
        }
        composable(NavigationTourScreen.FavoriteScreen.name) {
            FavoriteScreen(navController = navController)
        }
        composable(NavigationTourScreen.ProfileScreen.name) {
            ProfileScreen(navController = navController)
        }
        composable(NavigationTourScreen.ForgotPasswordScreen.name) {
            ForgotPasswordScreen(navController = navController)
        }
        composable(NavigationTourScreen.ChangePasswordSuccessScreen.name) {
            ChangePasswordSuccessScreen(navController = navController)
        }

        composable(NavigationTourScreen.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(NavigationTourScreen.FilteringScreen.name) {
            FilteringScreen(navController = navController)
        }

        composable(NavigationTourScreen.CartScreen.name) {
            CartScreen(navController = navController)
        }
        composable(NavigationTourScreen.TransactionSuccessScreen.name) {
            TransactionSuccessScreen(navController = navController)
        }
        composable(NavigationTourScreen.AboutProfileScreen.name) {
            AboutProfileScreen(navController = navController)
        }
        composable(
            route = "${NavigationTourScreen.DetailScreen.name}/{wisataId}",
            arguments = listOf(navArgument("wisataId") { type = NavType.StringType })
        ) {
            DetailScreen(
                navController = navController,
                wisataId = it.arguments?.getString("wisataId") ?: ""
            )
        }
    }
}
