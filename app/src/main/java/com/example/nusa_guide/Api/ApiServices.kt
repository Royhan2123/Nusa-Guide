package com.example.nusa_guide.Api

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("wisata")
    suspend fun getRekomendasi(): ApiResponse

    @GET("wisata/{id}")
    suspend fun getRekomendasiById(@Path("id") id: Int): ApiResponse
}