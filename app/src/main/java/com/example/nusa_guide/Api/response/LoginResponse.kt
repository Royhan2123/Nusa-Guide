package com.example.nusa_guide.Api.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("Authorization") val token: String? = null
)
