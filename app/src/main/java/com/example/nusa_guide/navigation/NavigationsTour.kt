package com.example.nusa_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.model.DummyData.paketPremiumList
import com.example.nusa_guide.model.PaketRegular
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.screen.AboutProfileScreen
import com.example.nusa_guide.screen.ChangePasswordSuccessScreen
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
import com.example.nusa_guide.screen.UlasanScreen
import com.example.nusa_guide.screen.UlasanSuccesScreen
import com.example.nusa_guide.screen.VerificationCodeScreen
import com.example.nusa_guide.screen.cameraX.CameraXScreen
import com.example.nusa_guide.screen.detail_screen.DetailPremiumScreen
import com.example.nusa_guide.screen.detail_screen.DetailScreen

@Composable
fun NavigationsTour() {
    val navController = rememberNavController()

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

    val rekomendasiList = listOf(
        Rekomendasi(
            id = 1,
            nama = "Pantai Kuta",
            gambar = R.drawable.tour_image_1,
            harga = 50000,
            jarak = 10.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 2,
            nama = "Pura Besakih",
            gambar = R.drawable.tour_image_1,
            harga = 75000,
            jarak = 25.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 3,
            nama = "Ubud Monkey ",
            gambar = R.drawable.bg_on_boarding,
            harga = 60000,
            jarak = 15.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 4,
            nama = "Tanah Lot",
            gambar = R.drawable.tour_image_1,
            harga = 80000,
            jarak = 30.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 5,
            nama = "Pantai Sanur",
            gambar = R.drawable.tour_image_1,
            harga = 45000,
            jarak = 12.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 6,
            nama = "Garuda Wisnu Kencana",
            gambar = R.drawable.tour_image_1,
            harga = 100000,
            jarak = 20.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 7,
            nama = "Tegallalang Rice Terrace",
            gambar = R.drawable.tour_image_1,
            harga = 55000,
            jarak = 18.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 8,
            nama = "Goa Gajah",
            gambar = R.drawable.tour_image_1,
            harga = 50000,
            jarak = 14.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 9,
            nama = "Pantai Jimbaran",
            gambar = R.drawable.bg_on_boarding,
            harga = 40000,
            jarak = 16.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        ),
        Rekomendasi(
            id = 10,
            nama = "Tirta Empul",
            gambar = R.drawable.bg_on_boarding,
            harga = 70000,
            jarak = 22.0,
            deskripsi = "Sebuah pulau indah di Bali.",
            cuplikanPhoto = R.drawable.pantai_1,
            informasiTourGuide = "Pemandu tur berpengalaman.",
            informasiHarga = "Harga termasuk makan siang.",
            ratingReview = 4,
            ulasan = 120,
            ulasanTitle = "Ulasan Terbaik",
            ulasanImage = R.drawable.pantai_2,
            deskripsiUlasan = "Tempat ini luar biasa!",
            cuplikanPhotoUlasan = listOf(
                R.drawable.pantai_1,
                R.drawable.pantai_2,
                R.drawable.pantai_3
            ),
            km = 7,
            waktuKeberangkatan = 18.00,
            lokasi = "Bali"
        )
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
            HalamanBottom(navController)
        }
        composable(NavigationTourScreen.HomeScreen.name) {
            HomeScreen(navController)
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
            RekomendasiScreen(navController, rekomendasiList)
        }
        composable(NavigationTourScreen.PaketPremiumScreen.name) {
            PaketPremiumScreen(navController, paketPremiumList)
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
        composable(NavigationTourScreen.DetailScreen.name) {
            DetailScreen()
        }
        composable(NavigationTourScreen.DetailPremiumScreen.name) {
            DetailPremiumScreen()
        }
        composable(NavigationTourScreen.PaketRegulerScreen.name) {
            PaketRegularScreen(navController = navController, paketRegularList = paketRegular )
        }
    }
}
