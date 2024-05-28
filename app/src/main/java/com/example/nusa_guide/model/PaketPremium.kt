package com.example.nusa_guide.model

data class PaketPremium(
    val id: Int,
    val nama: String,
    val gambar: Int,
    val harga: Int,
    val hariBerlibur: String,
    val jarak: Double,
    val deskripsi: String,
    val cuplikanPhotos: List<Int>,
    val informasiTourGuide: String,
    val informasiHarga: String,
    val ratingReview: Double,
    val ulasan: List<Ulasan>,
    val informasiPaket: InformasiPaket
)
data class Ulasan(

    val nama: String,
    val tanggal: String,
    val rating: Double,
    val deskripsi: String,
    val images: List<Int>
)

data class InformasiPaket(
    val include: List<String>,
    val exclude: List<String>,
)