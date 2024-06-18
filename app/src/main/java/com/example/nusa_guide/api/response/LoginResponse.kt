package com.example.nusa_guide.api.response

import com.example.nusa_guide.model.UserModel
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("Authorization") val token: String? = null,
    @SerializedName("data") val data: UserModel
)
