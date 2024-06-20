package com.example.nusa_guide.model

import com.google.gson.annotations.SerializedName

data class UserModel(

    @field:SerializedName("nama")
    val nama: Any? = null,

    @field:SerializedName("foto")
    val foto: Any? = null,

    @field:SerializedName("telepon")
    val telepon: Any? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("alamat")
    val alamat: Any? = null,

    @field:SerializedName("token")
    val token: String? = null
)
