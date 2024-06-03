package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.component.RekomendasiItem
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.navigation.NavigationTourScreen
import com.example.nusa_guide.ui.theme.NusaGuideTheme

@Composable
fun RekomendasiScreen(
    navController: NavController,
    rekomendasiList: List<Rekomendasi>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(2.dp)
    ) {
        items(rekomendasiList) { rekomendasi ->
            RekomendasiItem(rekomendasi = rekomendasi,
                onClick = {
                    navController.navigate(
                        NavigationTourScreen.DetailScreen.name
                    )
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RekomendasiScreenPreview() {
    NusaGuideTheme {
        val DummyData = listOf(
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
        RekomendasiScreen(rememberNavController(), DummyData)
    }
}
