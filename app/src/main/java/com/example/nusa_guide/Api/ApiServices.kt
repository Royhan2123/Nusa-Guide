package com.example.nusa_guide.Api

import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("wisata")
    suspend fun getRekomendasi(): ApiResponse

    @POST("auth/regiter")
    suspend fun register(): ApiResponse

    @POST("auth/login")
    suspend fun login(): ApiResponse

}