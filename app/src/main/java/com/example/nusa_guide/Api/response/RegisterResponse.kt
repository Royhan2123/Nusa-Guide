package com.example.nusa_guide.Api.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String
)
