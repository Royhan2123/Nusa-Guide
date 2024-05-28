package com.example.nusa_guide.navigation

enum class NavigationTourScreen {
    SplashScreen,
    OnBoardingScreen,
    OnBoardingScreen2,
    LoginScreen,
    RegisterScreen,
    HomeScreen,
    RiwayatScreen,
    FavoriteScreen,
    ProfileScreen,
    HalamanBottom,
    ChangePasswordSuccessScreen,
    ForgotPasswordScreen,
    VerificationCodeScreen,
    RekomendasiScreen,
    PaketPremiumScreen,
    PaketRegulerScreen,
    SearchScreen,
    AboutProfileScreen,
    UlasanScreen,
    UlasanSuccesScreen,
    FilteringScreen,
    CameraXScreen,
    DetailScreen,
    DetailPremiumScreen,
    CartScreen;
    fun fromRoute(route: String?): NavigationTourScreen =
        when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            OnBoardingScreen.name -> OnBoardingScreen
            OnBoardingScreen2.name -> OnBoardingScreen2
            LoginScreen.name -> LoginScreen
            RegisterScreen.name -> RegisterScreen
            HomeScreen.name -> HomeScreen
            RiwayatScreen.name -> RiwayatScreen
            FavoriteScreen.name -> FavoriteScreen
            ProfileScreen.name -> ProfileScreen
            HalamanBottom.name -> HalamanBottom
            ChangePasswordSuccessScreen.name -> ChangePasswordSuccessScreen
            ForgotPasswordScreen.name -> ForgotPasswordScreen
            VerificationCodeScreen.name -> VerificationCodeScreen
            RekomendasiScreen.name -> RekomendasiScreen
            PaketPremiumScreen.name -> PaketPremiumScreen
            PaketRegulerScreen.name -> PaketRegulerScreen
            SearchScreen.name -> SearchScreen
            AboutProfileScreen.name -> AboutProfileScreen
            UlasanScreen.name -> UlasanScreen
            FilteringScreen.name -> FilteringScreen
            UlasanSuccesScreen.name -> UlasanSuccesScreen
            CameraXScreen.name -> CameraXScreen
            DetailScreen.name -> DetailScreen
            DetailPremiumScreen.name -> DetailPremiumScreen
            CartScreen.name -> CartScreen
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }
}
