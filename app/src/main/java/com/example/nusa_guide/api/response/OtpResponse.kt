package com.example.nusa_guide.api.response

data class OtpResponse(
    val status: Boolean,
    val message: String,
    val data: OtpData
)
