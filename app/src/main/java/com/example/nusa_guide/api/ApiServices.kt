package com.example.nusa_guide.api

import com.example.nusa_guide.api.response.ApiResponse
import com.example.nusa_guide.api.response.LoginResponse
import com.example.nusa_guide.api.response.RegisterResponse
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.model.UserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("wisata")
    suspend fun getRekomendasi(
        @Header("Authorization") token: String
    ): ApiResponse

    @POST("auth/register")
    suspend fun register(@Body registerModel: RegisterModel): RegisterResponse

    @POST("auth/login")
    suspend fun login(@Body loginModel: LoginModel): LoginResponse

    @GET("user/{id}")
    suspend fun getUser(
        @Path("id") id: Int
    ): UserModel
}

