package com.example.nusa_guide.model

import com.google.gson.annotations.SerializedName

data class Rekomendasi(
    @SerializedName("id") val id: Int,
    @SerializedName("nama") val nama: String,
    @SerializedName("lokasi") val lokasi: String,
    @SerializedName("jam_buka") val jamBuka: String,
    @SerializedName("jam_tutup") val jamTutup: String,
    @SerializedName("jarak_lokasi") val jarakLokasi: String,
    @SerializedName("harga") val harga: Int,
    @SerializedName("deskripsi") val deskripsi: String,
    @SerializedName("gambar1") val gambar1: String,
    @SerializedName("gambar2") val gambar2: String,
    @SerializedName("gambar3") val gambar3: String,
    @SerializedName("gambar4") val gambar4: String,
    @SerializedName("informasi_tourguide") val informasiTourguide: String,
    @SerializedName("harga_termasuk") val hargaTermasuk: String,
    @SerializedName("kategori") val kategori: String
)