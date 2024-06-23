package com.example.nusa_guide.model

import com.example.nusa_guide.R
import com.google.gson.annotations.SerializedName

data class FavoritModel(
//    val id: Int,
//    val title: String,
//    val waktu:Double,
//    val waktuSelesai:Double,
//    val km: Int,
//    val menit: Int,
//    val rating: Double,
//    val harga: Int,
//    val potonganHarga:Int,
//    val diskon:Int,
//    val image:Int,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("lokasi")
    val lokasi: String? = null,

    @field:SerializedName("jam_buka")
    val jam_buka: String? = null,

    @field:SerializedName("jam_tutup")
    val jam_tutup: String? = null,

    @field:SerializedName("jarak_lokasi")
    val jarak_lokasi: String? = null,

    @field:SerializedName("harga")
    val harga: Int? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null,

    @field:SerializedName("gambar1")
    val gambar1: String? = null,

    @field:SerializedName("gambar2")
    val gambar2: String? = null,

    @field:SerializedName("gambar3")
    val gambar3: String? = null,

    @field:SerializedName("gambar4")
    val gambar4: String? = null,

    @field:SerializedName("informasi_tourguide")
    val informasi_tourguide: String? = null,

    @field:SerializedName("harga_termasuk")
    val harga_termasuk: String? = null,

    @field:SerializedName("kategori")
    val kategori: String? = null,

    @field:SerializedName("created_at")
    val created_at: String? = null,

    @field:SerializedName("updated_at")
    val updated_at: String? = null,

    @field:SerializedName("payment_link")
    val payment_link: String? = null,

    @field:SerializedName("rating")
    val rating: Int
)

//val dummyListFavoritModel = listOf(
//    FavoritModel(
//        id = 1,
//        title = "Pantai Pandawa",
//        waktu = 6.00,
//        waktuSelesai = 18.00,
//        km = 1,
//        rating = 4.5,
//        harga = 150000,
//        potonganHarga = 500000,
//        diskon = 50,
//        image = R.drawable.alam,
//        menit = 20
//    ),
//    FavoritModel(
//        id = 2,
//        title = "Pantai Pandawa",
//        waktu = 6.00,
//        waktuSelesai = 18.00,
//        km = 5,
//        rating = 4.5,
//        harga = 150000,
//        potonganHarga = 500000,
//        diskon = 50,
//        image = R.drawable.budaya,
//        menit = 20
//    ),
//    FavoritModel(
//        id = 3,
//        title = "Pantai Pandawa",
//        waktu = 6.00,
//        waktuSelesai = 18.00,
//        km = 1,
//        rating = 4.5,
//        harga = 150000,
//        potonganHarga = 500000,
//        diskon = 50,
//        image = R.drawable.tour,
//        menit = 20
//    ),
//    FavoritModel(
//        id = 4,
//        title = "Pantai Pandawa",
//        waktu = 6.00,
//        waktuSelesai = 18.00,
//        km = 1,
//        rating = 4.5,
//        harga = 150000,
//        potonganHarga = 500000,
//        diskon = 50,
//        image = R.drawable.alam,
//        menit = 20
//    ),
//)
