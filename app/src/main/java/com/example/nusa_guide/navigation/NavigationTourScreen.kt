package com.example.nusa_guide.navigation
enum class NavigationTourScreen {
    SplashScreen,
    OnBoardingScreen,
    OnBoardingScreen2,
    LoginScreen,
    RegisterScreen,
    HomeScreen,
    RiwayatScreen,
    FavoritScreen,
    ProfilScreen,
    HalamanBottom,
    ChangePasswordSuccessScreen,
    ForgotPasswordScreen,
    VerificationCodeScreen,
    RekomendasiScreen,
    PaketPremiumScreen,
    SearchScreen;

    fun fromRoute(route:String?): NavigationTourScreen =
        when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            OnBoardingScreen.name -> OnBoardingScreen
            OnBoardingScreen2.name -> OnBoardingScreen2
            LoginScreen.name -> LoginScreen
            RegisterScreen.name -> RegisterScreen
            HomeScreen.name -> HomeScreen
            RiwayatScreen.name -> RiwayatScreen
            FavoritScreen.name -> FavoritScreen
            ProfilScreen.name -> ProfilScreen
            HalamanBottom.name -> HalamanBottom
            ChangePasswordSuccessScreen.name -> ChangePasswordSuccessScreen
            ForgotPasswordScreen.name -> ForgotPasswordScreen
            VerificationCodeScreen.name -> VerificationCodeScreen
            RekomendasiScreen.name -> RekomendasiScreen
            PaketPremiumScreen.name -> PaketPremiumScreen
            SearchScreen.name -> SearchScreen

            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }

}