package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.DummyData.paketPremiumList
import com.example.nusa_guide.model.PaketRegular
import com.example.nusa_guide.repository.AuthRepository
import com.example.nusa_guide.repository.RekomendasiRepository
import com.example.nusa_guide.screen.AboutProfileScreen
import com.example.nusa_guide.screen.CartScreen
import com.example.nusa_guide.screen.ChangePasswordSuccessScreen
import com.example.nusa_guide.screen.DetailTransactionScreen
import com.example.nusa_guide.screen.FavoriteScreen
import com.example.nusa_guide.screen.FilteringScreen
import com.example.nusa_guide.screen.ForgotPasswordScreen
import com.example.nusa_guide.screen.HalamanBottom
import com.example.nusa_guide.screen.HomeScreen
import com.example.nusa_guide.screen.LoginScreen
import com.example.nusa_guide.screen.OnBoardingScreen
import com.example.nusa_guide.screen.OnBoardingScreen2
import com.example.nusa_guide.screen.PaketPremiumScreen
import com.example.nusa_guide.screen.PaketRegularScreen
import com.example.nusa_guide.screen.ProfileScreen
import com.example.nusa_guide.screen.RegisterScreen
import com.example.nusa_guide.screen.RekomendasiScreen
import com.example.nusa_guide.screen.RiwayatScreen
import com.example.nusa_guide.screen.SearchScreen
import com.example.nusa_guide.screen.SplashScreen
import com.example.nusa_guide.screen.TransactionSuccessScreen
import com.example.nusa_guide.screen.UlasanScreen
import com.example.nusa_guide.screen.UlasanSuccesScreen
import com.example.nusa_guide.screen.UploadBuktiScreen
import com.example.nusa_guide.screen.VerificationCodeScreen
import com.example.nusa_guide.screen.cameraX.CameraXScreen
import com.example.nusa_guide.screen.detail_screen.DetailPremiumScreen
import com.example.nusa_guide.screen.detail_screen.DetailScreen
import com.example.nusa_guide.screen.payment.PaymentDetailsUI
import com.example.nusa_guide.screen.payment.PaymentScreen
import com.example.nusa_guide.viewModel.AuthViewModel
import com.example.nusa_guide.viewModel.AuthViewModelFactory
import com.example.nusa_guide.viewModel.PaketRekomendasiViewModelFactory
import com.example.nusa_guide.viewModel.RekomendasiViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


val paketRegular = listOf(
    PaketRegular(
        id = 1,
        nama = "3 Wisata - 2 Hari",
        gambar = R.drawable.tour_image_1,
        harga = 350000,
        jarak = 0.64,
        rating = 4.5f
    ),
    PaketRegular(
        id = 2,
        nama = "2 Wisata - 1 Hari",
        gambar = R.drawable.tour_image_1,
        harga = 250000,
        jarak = 0.34,
        rating = 4.0f
    ),
    PaketRegular(
        id = 3,
        nama = "4 Wisata - 3 Hari",
        gambar = R.drawable.tour_image_1,
        harga = 450000,
        jarak = 1.0,
        rating = 4.8f
    ),
    PaketRegular(
        id = 4,
        nama = "5 Wisata - 4 Hari",
        gambar = R.drawable.tour_image_1,
        harga = 500000,
        jarak = 1.5,
        rating = 4.7f
    ),
    PaketRegular(
        id = 5,
        nama = "6 Wisata - 5 Hari",
        gambar = R.drawable.tour_image_1,
        harga = 550000,
        jarak = 2.0,
        rating = 4.9f
    ),
    PaketRegular(
        id = 6,
        nama = "7 Wisata - 6 Hari",
        gambar = R.drawable.tour_image_1,
        harga = 600000,
        jarak = 2.5,
        rating = 5.0f
    ),
)

@Composable
fun NavigationsTour() {
    val navController = rememberNavController()
    val authRepository = AuthRepository(
        FirebaseAuth.getInstance(),
        FirebaseFirestore.getInstance(),
        LocalContext.current
    )
    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(authRepository)
    )
    val rekomendasiViewModel: RekomendasiViewModel = viewModel(
        factory = PaketRekomendasiViewModelFactory(
            RekomendasiRepository(FirebaseFirestore.getInstance())
        )
    )
    val rekomendasiList by rekomendasiViewModel.paketRekomendasi.observeAsState()

    NavHost(
        navController = navController,
        startDestination = NavigationTourScreen.SplashScreen.name
    ) {
        composable(NavigationTourScreen.SplashScreen.name) {
            SplashScreen(navController = navController, authViewModel)
        }
        composable(NavigationTourScreen.OnBoardingScreen.name) {
            OnBoardingScreen(navController = navController)
        }
        composable(NavigationTourScreen.OnBoardingScreen2.name) {
            OnBoardingScreen2(navController = navController)
        }
        composable(NavigationTourScreen.LoginScreen.name) {
            LoginScreen(navController = navController, authViewModel)
        }
        composable(NavigationTourScreen.RegisterScreen.name) {
            RegisterScreen(navController = navController, authViewModel)
        }
        composable(NavigationTourScreen.HalamanBottom.name) {
            HalamanBottom(navController)
        }
        composable(NavigationTourScreen.HomeScreen.name) {
            HomeScreen(navController, authViewModel)
        }
        composable(NavigationTourScreen.FavoriteScreen.name) {
            FavoriteScreen(navController)
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
            rekomendasiList?.let {
                RekomendasiScreen(navController, it)
            } ?: run {
            }
        }
        composable(NavigationTourScreen.PaketPremiumScreen.name) {
            PaketPremiumScreen(navController, paketPremiumList)
        }
        composable(NavigationTourScreen.AboutProfileScreen.name) {
            AboutProfileScreen(navController, authViewModel)
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

        composable(NavigationTourScreen.DetailScreen.name) {
            DetailScreen(navController)
        }

        composable(NavigationTourScreen.DetailPremiumScreen.name) {
            DetailPremiumScreen()
        }
        composable(NavigationTourScreen.PaketRegulerScreen.name) {
            PaketRegularScreen(navController = navController, paketRegularList = paketRegular)
        }
        composable(NavigationTourScreen.CartScreen.name) {
            CartScreen(navController = navController)
        }
        composable(NavigationTourScreen.UploadBuktiScreen.name) {
            UploadBuktiScreen(navController = navController)
        }
        composable(NavigationTourScreen.PaymentDetailsUI.name) {
            PaymentDetailsUI(navController = navController)
        }
        composable(NavigationTourScreen.PaymentScreen.name) {
            PaymentScreen(navController = navController)
        }
        composable(NavigationTourScreen.TransactionSuccessScreen.name) {
            TransactionSuccessScreen(navController = navController)
        }
        composable(NavigationTourScreen.DetailTransactionScreen.name) {
            DetailTransactionScreen(navController = navController)
        }
    }
}
