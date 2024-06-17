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
