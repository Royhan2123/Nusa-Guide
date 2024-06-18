package com.example.nusa_guide.navigation

enum class NavigationTourScreen {
    SplashScreen,
    OnBoardingScreen,
    OnBoardingScreen2,
    LoginScreen,
    RegisterScreen,
    HomeScreen,
    FavoriteScreen,
    ProfileScreen,
    HalamanBottom,
    ChangePasswordSuccessScreen,
    ForgotPasswordScreen,
    VerificationCodeScreen,
    SearchScreen,
    AboutProfileScreen,
    UlasanScreen,
    UlasanSuccesScreen,
    FilteringScreen,
    CameraXScreen,
    DetailScreen,
    CartScreen,
    TransactionSuccessScreen;
    fun fromRoute(route: String?): NavigationTourScreen =
        when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            OnBoardingScreen.name -> OnBoardingScreen
            OnBoardingScreen2.name -> OnBoardingScreen2
            LoginScreen.name -> LoginScreen
            RegisterScreen.name -> RegisterScreen
            HomeScreen.name -> HomeScreen
            FavoriteScreen.name -> FavoriteScreen
            ProfileScreen.name -> ProfileScreen
            HalamanBottom.name -> HalamanBottom
            ChangePasswordSuccessScreen.name -> ChangePasswordSuccessScreen
            ForgotPasswordScreen.name -> ForgotPasswordScreen
            VerificationCodeScreen.name -> VerificationCodeScreen
            SearchScreen.name -> SearchScreen
            AboutProfileScreen.name -> AboutProfileScreen
            UlasanScreen.name -> UlasanScreen
            FilteringScreen.name -> FilteringScreen
            UlasanSuccesScreen.name -> UlasanSuccesScreen
            CameraXScreen.name -> CameraXScreen
            DetailScreen.name -> DetailScreen
            CartScreen.name -> CartScreen
            TransactionSuccessScreen.name -> TransactionSuccessScreen
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }
}
