package com.example.nusa_guide.Api

data class ApiResponse(
    val success: Boolean,
    val message: String?,
    val data: Any?
)