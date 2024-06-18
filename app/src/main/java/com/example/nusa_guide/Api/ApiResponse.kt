package com.example.nusa_guide.Api

import com.example.nusa_guide.model.WisataModel
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<WisataModel>
)