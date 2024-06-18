package com.example.nusa_guide.model

import com.google.gson.annotations.SerializedName

data class WisataModel(

    @field:SerializedName("jam_tutup")
    val jamTutup: String? = null,

    @field:SerializedName("gambar4")
    val gambar4: String? = null,

    @field:SerializedName("gambar1")
    val gambar1: String? = null,

    @field:SerializedName("gambar3")
    val gambar3: String? = null,

    @field:SerializedName("gambar2")
    val gambar2: String? = null,

    @field:SerializedName("jarak_lokasi")
    val jarakLokasi: String? = null,

    @field:SerializedName("kategori")
    val kategori: String? = null,

    @field:SerializedName("harga_termasuk")
    val hargaTermasuk: String? = null,

    @field:SerializedName("jam_buka")
    val jamBuka: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("harga")
    val harga: Int? = null,

    @field:SerializedName("lokasi")
    val lokasi: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null,

    @field:SerializedName("informasi_tourguide")
    val informasiTourguide: String? = null,

)
