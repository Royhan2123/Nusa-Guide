package com.example.nusa_guide.Api

import com.example.nusa_guide.Api.response.ApiResponse
import com.example.nusa_guide.Api.response.LoginResponse
import com.example.nusa_guide.Api.response.RegisterResponse
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("wisata")
    suspend fun getRekomendasi(): ApiResponse

    @POST("auth/register")
    suspend fun register(@Body registerModel: RegisterModel): RegisterResponse

    @POST("auth/login")
    suspend fun login(@Body loginModel: LoginModel): LoginResponse

}