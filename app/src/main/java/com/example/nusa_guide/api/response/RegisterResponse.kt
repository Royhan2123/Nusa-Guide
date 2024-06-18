package com.example.nusa_guide.api.response

import com.example.nusa_guide.model.UserModel
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: UserModel
)
