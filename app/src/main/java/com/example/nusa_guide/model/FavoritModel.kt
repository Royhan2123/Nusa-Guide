package com.example.nusa_guide.model

import com.example.nusa_guide.R

data class FavoritModel(
    val id: Int,
    val title: String,
    val waktu:Double,
    val waktuSelesai:Double,
    val km: Int,
    val menit: Int,
    val rating: Double,
    val harga: Int,
    val potonganHarga:Int,
    val diskon:Int,
    val image:Int,
)

val dummyListFavoritModel = listOf(
    FavoritModel(
        id = 1,
        title = "Pantai Pandawa",
        waktu = 6.00,
        waktuSelesai = 18.00,
        km = 1,
        rating = 4.5,
        harga = 150000,
        potonganHarga = 500000,
        diskon = 50,
        image = R.drawable.alam,
        menit = 20
    ),
    FavoritModel(
        id = 2,
        title = "Pantai Pandawa",
        waktu = 6.00,
        waktuSelesai = 18.00,
        km = 5,
        rating = 4.5,
        harga = 150000,
        potonganHarga = 500000,
        diskon = 50,
        image = R.drawable.budaya,
        menit = 20
    ),
    FavoritModel(
        id = 3,
        title = "Pantai Pandawa",
        waktu = 6.00,
        waktuSelesai = 18.00,
        km = 1,
        rating = 4.5,
        harga = 150000,
        potonganHarga = 500000,
        diskon = 50,
        image = R.drawable.tour,
        menit = 20
    ),
    FavoritModel(
        id = 4,
        title = "Pantai Pandawa",
        waktu = 6.00,
        waktuSelesai = 18.00,
        km = 1,
        rating = 4.5,
        harga = 150000,
        potonganHarga = 500000,
        diskon = 50,
        image = R.drawable.alam,
        menit = 20
    ),
)