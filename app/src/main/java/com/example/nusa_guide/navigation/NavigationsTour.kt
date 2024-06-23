    package com.example.nusa_guide.navigation

    import androidx.compose.runtime.Composable
    import androidx.navigation.NavType
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import androidx.navigation.navArgument
    import com.example.nusa_guide.model.FavoritModel
    import com.example.nusa_guide.screen.*
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
            composable(NavigationTourScreen.VerificationCodeScreen.name) {
                VerificationCodeScreen(navController = navController)
            }
            composable(NavigationTourScreen.SearchScreen.name) {
                SearchScreen(navController = navController)
            }
            composable(NavigationTourScreen.FilteringScreen.name) {
                FilteringScreen(navController = navController)
            }
            composable(NavigationTourScreen.CameraXScreen.name) {
                CameraXScreen(navController = navController)
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
                DetailScreen(navController = navController, wisataId = it.arguments?.getString("wisataId") ?: "")
            }
        }
    }
