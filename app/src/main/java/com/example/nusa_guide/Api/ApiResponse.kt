package com.example.nusa_guide.Api

import com.example.nusa_guide.model.RekomendasiModel
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<RekomendasiModel>
)