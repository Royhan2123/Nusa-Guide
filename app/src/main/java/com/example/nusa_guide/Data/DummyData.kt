package com.example.nusa_guide.model

import com.example.nusa_guide.R

object DummyData {
    val paketPremiumList = listOf(
        PaketPremium(
            id = 1,
            nama = "10 Wisata - 9 Hari",
            gambar = R.drawable.tour_image_1,
            harga = 1350000,
            jarak = 64
        ),
        PaketPremium(
            id = 2,
            nama = "7 Wisata - 7 Hari",
            gambar = R.drawable.tour_image_1,
            harga = 1000000,
            jarak = 64
        ),
        PaketPremium(
            id = 3,
            nama = "15 Wisata - 10 Hari",
            gambar = R.drawable.tour_image_1,
            harga = 1500000,
            jarak = 64
        ),
        PaketPremium(
            id = 4,
            nama = "7 Wisata - 6 Hari",
            gambar = R.drawable.tour_image_1,
            harga = 1000000,
            jarak = 64
        ),
        PaketPremium(
            id = 5,
            nama = "10 Wisata - 9 Hari",
            gambar = R.drawable.tour_image_1,
            harga = 1350000,
            jarak = 64
        ),
        PaketPremium(
            id = 6,
            nama = "7 Wisata - 7 Hari",
            gambar = R.drawable.tour_image_1,
            harga = 1000000,
            jarak = 64
        )
    )

    val rekomendasiList = listOf(
        Rekomendasi(
            id = 1,
            nama = "Pantai Kuta",
            gambar = R.drawable.tour_image_1,
            harga = 50000,
            jarak = 10
        ),
        Rekomendasi(
            id = 2,
            nama = "Pura Besakih",
            gambar = R.drawable.tour_image_1,
            harga = 75000,
            jarak = 25
        ),
        Rekomendasi(
            id = 3,
            nama = "Ubud Monkey Forest",
            gambar = R.drawable.tour_image_1,
            harga = 60000,
            jarak = 15
        ),
        Rekomendasi(
            id = 4,
            nama = "Tanah Lot",
            gambar = R.drawable.tour_image_1,
            harga = 80000,
            jarak = 30
        ),
        Rekomendasi(
            id = 5,
            nama = "Pantai Sanur",
            gambar = R.drawable.tour_image_1,
            harga = 45000,
            jarak = 12
        ),
        Rekomendasi(
            id = 6,
            nama = "Garuda Wisnu Kencana",
            gambar = R.drawable.tour_image_1,
            harga = 100000,
            jarak = 20
        ),
        Rekomendasi(
            id = 7,
            nama = "Tegallalang Rice Terrace",
            gambar = R.drawable.tour_image_1,
            harga = 55000,
            jarak = 18
        ),
        Rekomendasi(
            id = 8,
            nama = "Goa Gajah",
            gambar = R.drawable.tour_image_1,
            harga = 50000,
            jarak = 14
        ),
        Rekomendasi(
            id = 9,
            nama = "Pantai Jimbaran",
            gambar = R.drawable.bg_on_boarding,
            harga = 40000,
            jarak = 16
        ),
        Rekomendasi(
            id = 10,
            nama = "Tirta Empul",
            gambar = R.drawable.bg_on_boarding,
            harga = 70000,
            jarak = 22
        )
    )

    val paketRegularList = listOf(
        PaketRegular(
            id = 1,
            nama = "Pantai Kuta",
            gambar = R.drawable.tour_image_1, // pastikan untuk memiliki gambar yang sesuai di drawable
            harga = 50000,
            jarak = 10.0,
            rating = 4.5f
        ),
        PaketRegular(
            id = 2,
            nama = "Ubud Monkey Forest",
            gambar = R.drawable.bg_on_boarding, // pastikan untuk memiliki gambar yang sesuai di drawable
            harga = 75000,
            jarak = 20.0,
            rating = 4.7f
        ),
        PaketRegular(
            id = 3,
            nama = "Tanah Lot",
            gambar = R.drawable.tour_image_1, // pastikan untuk memiliki gambar yang sesuai di drawable
            harga = 60000,
            jarak = 30.0,
            rating = 4.6f
        ),
        PaketRegular(
            id = 4,
            nama = "Pura Ulun Danu Bratan",
            gambar = R.drawable.bg_on_boarding, // pastikan untuk memiliki gambar yang sesuai di drawable
            harga = 55000,
            jarak = 40.0,
            rating = 4.8f
        ),
        PaketRegular(
            id = 5,
            nama = "Tegallalang Rice Terrace",
            gambar = R.drawable.tour_image_1, // pastikan untuk memiliki gambar yang sesuai di drawable
            harga = 45000,
            jarak = 25.0,
            rating = 4.4f
        )
    )
}
