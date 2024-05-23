package com.example.nusa_guide.model

import java.util.Date

data class CardBelumBayarModel(
    val targetWisata: Int,
    val hargaWisata: Int,
    val jumlahTiket: Int,
    val namaTourGuide: String,
    val totalHarga: Int,
    val tambahanHarga: Int,
    val noPemesanan: String,
    val tanggalPemesanan: Date,
    val waktuPemesanan: Date,
)
