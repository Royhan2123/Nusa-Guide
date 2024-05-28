
package com.example.nusa_guide.model

data class Rekomendasi(
    val id: Int,
    val nama: String,
    val gambar: Int,
    val harga: Int,
    val jarak: Double,
    val lokasi: String,
    val waktuKeberangkatan: Double,
    val km: Int,
    val deskripsi: String,
    val cuplikanPhoto: Int,
    val informasiTourGuide: String,
    val informasiHarga: String,
    val ratingReview: Int,
    val ulasan: Int,
    val ulasanTitle: String,
    val ulasanImage: Int,
    val deskripsiUlasan: String,
    val cuplikanPhotoUlasan: List<Int>,
)
