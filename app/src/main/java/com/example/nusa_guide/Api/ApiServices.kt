package com.example.nusa_guide.Api

import retrofit2.http.GET

interface ApiService {
    @GET("wisata")
    suspend fun getRekomendasi(): ApiResponse

}