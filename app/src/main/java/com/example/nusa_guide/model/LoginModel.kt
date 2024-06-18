package com.example.nusa_guide.model

import com.google.gson.annotations.SerializedName

data class LoginModel(

    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("password")
    val password: String? = null,
)
