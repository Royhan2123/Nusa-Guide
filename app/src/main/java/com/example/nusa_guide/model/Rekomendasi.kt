package com.example.nusa_guide.model

data class Rekomendasi(
    val id: String= "",
    val nama: String= "",
    val gambar: String= "",
    val harga: String= "",
    val jarak: String= "",
    val lokasi: String= "",
    val waktuKeberangkatan: String= "",
    val km: String= "",
    val deskripsi: String= "",
    val cuplikanPhoto: List<String> = emptyList(),
    val informasiTourGuide: String= "",
    val informasiHarga: List<String> = emptyList(),
    val ratingReview: String= "",
    val ulasan: String= "",
    val ulasanTitle: String= "",
    val ulasanImage: String= "",
    val deskripsiUlasan: String= "",
    val cuplikanPhotoUlasan: List<String> = emptyList()
)
