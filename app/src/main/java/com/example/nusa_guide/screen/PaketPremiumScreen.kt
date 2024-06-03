package com.example.nusa_guide.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nusa_guide.R
import com.example.nusa_guide.component.PaketPremiumItem
import com.example.nusa_guide.model.InformasiPaket
import com.example.nusa_guide.model.PaketPremium
import com.example.nusa_guide.model.Ulasan
import com.example.nusa_guide.ui.theme.NusaGuideTheme

@Composable
fun PaketPremiumScreen(
    navController: NavController,
    paketPremiumList: List<PaketPremium>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(paketPremiumList.size) { index ->
            PaketPremiumItem(
                paketPremium = paketPremiumList[index],
                onItemClicked = {},
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PaketPremiumScreenPreview() {
    NusaGuideTheme {
        val dummyData = listOf(
            PaketPremium(
                id = 1,
                nama = "10 Wisata - 9 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 350000,
                jarak = 64.0,
                deskripsi = "Deskripsi paket wisata",
                cuplikanPhotos = listOf(
                    R.drawable.pantai_1, R.drawable.pantai_2
                ),
                informasiTourGuide = "Informasi tentang tour guide",
                informasiHarga = "Harga termasuk akomodasi",
                ratingReview = 5.0,
                ulasan = listOf(
                    Ulasan(
                        nama = "Jonathan Kaje",
                        tanggal = "20 Minggu lalu",
                        rating = 4.0,
                        deskripsi = "Tour Guide Rekomendasi! Puoll!! untuk dipesan muantapp...",
                        images = listOf(R.drawable.pantai_1)
                    )
                ),
                informasiPaket = InformasiPaket(
                    include = listOf(
                        "Penjemputan dan pengantaran dari titik pertemuan yang ditentukan",
                        "Hotel",
                        "Supir",
                        "Tour Guide"
                    ),
                    exclude = listOf(
                        "Tip tour guide (min. Rp 50.000/hari)",
                        "Tip supir (min. Rp 75.000/hari)"
                    )
                ),
                hariBerlibur = "10 Hari",
            ),
            PaketPremium(
                id = 2,
                nama = "7 Wisata - 7 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 400000,
                jarak = 64.0,
                deskripsi = "Deskripsi paket wisata",
                cuplikanPhotos = listOf(
                    R.drawable.pantai_1, R.drawable.pantai_2
                ),
                informasiTourGuide = "Informasi tentang tour guide",
                informasiHarga = "Harga termasuk akomodasi",
                ratingReview = 5.0,
                ulasan = listOf(
                    Ulasan(
                        nama = "Jonathan Kaje",
                        tanggal = "20 Minggu lalu",
                        rating = 4.0,
                        deskripsi = "Tour Guide Rekomendasi! Puoll!! untuk dipesan muantapp...",
                        images = listOf(R.drawable.pantai_1)
                    )
                ),
                informasiPaket = InformasiPaket(
                    include = listOf(
                        "Penjemputan dan pengantaran dari titik pertemuan yang ditentukan",
                        "Hotel",
                        "Supir",
                        "Tour Guide"
                    ),
                    exclude = listOf(
                        "Tip tour guide (min. Rp 50.000/hari)",
                        "Tip supir (min. Rp 75.000/hari)"
                    )
                ),
                hariBerlibur = "10 Hari",
            ),
            PaketPremium(
                id = 3,
                nama = "15 Wisata - 10 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 450000,
                jarak = 64.0,
                deskripsi = "Deskripsi paket wisata",
                cuplikanPhotos = listOf(
                    R.drawable.pantai_1, R.drawable.pantai_2
                ),
                informasiTourGuide = "Informasi tentang tour guide",
                informasiHarga = "Harga termasuk akomodasi",
                ratingReview = 5.0,
                ulasan = listOf(
                    Ulasan(
                        nama = "Jonathan Kaje",
                        tanggal = "20 Minggu lalu",
                        rating = 4.0,
                        deskripsi = "Tour Guide Rekomendasi! Puoll!! untuk dipesan muantapp...",
                        images = listOf(R.drawable.pantai_1)
                    )
                ),
                informasiPaket = InformasiPaket(
                    include = listOf(
                        "Penjemputan dan pengantaran dari titik pertemuan yang ditentukan",
                        "Hotel",
                        "Supir",
                        "Tour Guide"
                    ),
                    exclude = listOf(
                        "Tip tour guide (min. Rp 50.000/hari)",
                        "Tip supir (min. Rp 75.000/hari)"
                    )
                ),
                hariBerlibur = "10 Hari",
            ),
            PaketPremium(
                id = 4,
                nama = "7  Wisata - 6 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 500000,
                jarak = 64.0,
                deskripsi = "Deskripsi paket wisata",
                cuplikanPhotos = listOf(
                    R.drawable.pantai_1, R.drawable.pantai_2
                ),
                informasiTourGuide = "Informasi tentang tour guide",
                informasiHarga = "Harga termasuk akomodasi",
                ratingReview = 5.0,
                ulasan = listOf(
                    Ulasan(
                        nama = "Jonathan Kaje",
                        tanggal = "20 Minggu lalu",
                        rating = 4.0,
                        deskripsi = "Tour Guide Rekomendasi! Puoll!! untuk dipesan muantapp...",
                        images = listOf(R.drawable.pantai_1)
                    )
                ),
                informasiPaket = InformasiPaket(
                    include = listOf(
                        "Penjemputan dan pengantaran dari titik pertemuan yang ditentukan",
                        "Hotel",
                        "Supir",
                        "Tour Guide"
                    ),
                    exclude = listOf(
                        "Tip tour guide (min. Rp 50.000/hari)",
                        "Tip supir (min. Rp 75.000/hari)"
                    )
                ),
                hariBerlibur = "10 Hari",
            ),
            PaketPremium(
                id = 5,
                nama = "10 Wisata - 9 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 550000,
                jarak = 64.0,
                deskripsi = "Deskripsi paket wisata",
                cuplikanPhotos = listOf(
                    R.drawable.pantai_1, R.drawable.pantai_2
                ),
                informasiTourGuide = "Informasi tentang tour guide",
                informasiHarga = "Harga termasuk akomodasi",
                ratingReview = 5.0,
                ulasan = listOf(
                    Ulasan(
                        nama = "Jonathan Kaje",
                        tanggal = "20 Minggu lalu",
                        rating = 4.0,
                        deskripsi = "Tour Guide Rekomendasi! Puoll!! untuk dipesan muantapp...",
                        images = listOf(R.drawable.pantai_1)
                    )
                ),
                informasiPaket = InformasiPaket(
                    include = listOf(
                        "Penjemputan dan pengantaran dari titik pertemuan yang ditentukan",
                        "Hotel",
                        "Supir",
                        "Tour Guide"
                    ),
                    exclude = listOf(
                        "Tip tour guide (min. Rp 50.000/hari)",
                        "Tip supir (min. Rp 75.000/hari)"
                    )
                ),
                hariBerlibur = "10 Hari",
            ),
            PaketPremium(
                id = 6,
                nama = "7 Wisata - 7 Hari",
                gambar = R.drawable.tour_image_1,
                harga = 550000,
                jarak = 64.0,
                deskripsi = "Deskripsi paket wisata",
                cuplikanPhotos = listOf(
                    R.drawable.pantai_1, R.drawable.pantai_2
                ),
                informasiTourGuide = "Informasi tentang tour guide",
                informasiHarga = "Harga termasuk akomodasi",
                ratingReview = 5.0,
                ulasan = listOf(
                    Ulasan(
                        nama = "Jonathan Kaje",
                        tanggal = "20 Minggu lalu",
                        rating = 4.0,
                        deskripsi = "Tour Guide Rekomendasi! Puoll!! untuk dipesan muantapp...",
                        images = listOf(R.drawable.pantai_1)
                    )
                ),
                informasiPaket = InformasiPaket(
                    include = listOf(
                        "Penjemputan dan pengantaran dari titik pertemuan yang ditentukan",
                        "Hotel",
                        "Supir",
                        "Tour Guide"
                    ),
                    exclude = listOf(
                        "Tip tour guide (min. Rp 50.000/hari)",
                        "Tip supir (min. Rp 75.000/hari)"
                    )
                ),
                hariBerlibur = "10 Hari",
            ),
        )
        PaketPremiumScreen(rememberNavController(), dummyData)
    }
}