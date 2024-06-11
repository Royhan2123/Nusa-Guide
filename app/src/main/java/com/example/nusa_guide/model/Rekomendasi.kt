package com.example.nusa_guide.model

import java.util.Date

data class Rekomendasi(
    val id: Int,
    val nama: String,
    val lokasi: String,
    val jamBuka: Date,
    val jamTutup: Date,
    val jarakLokasi: String,
    val harga: Int,
    val deskripsi: String,
    val gambar1: Int,
    val gambar2: Int,
    val gambar3: Int,
    val gambar4: Int,
    val informasiTourguide: String,
    val hargaTermasuk: String,
    val kategori:String,
)
