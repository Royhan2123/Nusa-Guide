package com.example.nusa_guide.model

import com.example.nusa_guide.R

data class FavoritModel(
    val id: Int,
    val title: String,
    val waktu:Double,
    val waktuSelesai:Double,
    val km: Int,
    val rating: Double,
    val harga: Int,
    val image:Int,
)

val dummyListFavoritModel = listOf(
    FavoritModel(
        id = 1,
        title = "Sidemen Valley",
        waktu = 00.00,
        waktuSelesai = 23.59,
        km = 54,
        rating = 4.8,
        harga = 200000,
        image = R.drawable.sidemen_valley,
    ),
    FavoritModel(
        id = 2,
        title = "Pantai Pandawa",
        waktu = 6.00,
        waktuSelesai = 18.00,
        km = 5,
        rating = 4.5,
        harga = 150000,
        image = R.drawable.goa_batu,
    ),
)