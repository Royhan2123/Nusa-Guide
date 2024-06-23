package com.example.nusa_guide.api

import com.example.nusa_guide.api.response.ApiResponse
import com.example.nusa_guide.api.response.FavoriteResponse
import com.example.nusa_guide.api.response.LoginResponse
import com.example.nusa_guide.api.response.LogoutResponse
import com.example.nusa_guide.api.response.RegisterResponse
import com.example.nusa_guide.api.response.UserResponse
import com.example.nusa_guide.model.FavoritModel
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("wisata")
    suspend fun getRekomendasi(
        @Header("Authorization") token: String
    ): ApiResponse

    @GET("wisata")
    suspend fun getWisataByKategori(
        @Header("Authorization") token: String,
        @Query("kategori") kategori: String
    ): ApiResponse

    @GET("wisata")
    suspend fun getWisataByRating(
        @Header("Authorization") token: String,
        @Query("rating") rating: Int
    ): ApiResponse

    @POST("auth/register")
    suspend fun register(
        @Body registerModel: RegisterModel
    ): RegisterResponse

    @POST("auth/login")
    suspend fun login(
        @Body loginModel: LoginModel
    ): LoginResponse

    @GET("user")
    suspend fun getUser(
        @Header("Authorization") token: String
    ): UserResponse

    @POST("auth/logout")
    suspend fun logout(
        @Header("Authorization") token: String
    ): LogoutResponse

    @GET("favorite")
    suspend fun getFavorite(
        @Header("Authorization") token: String
    ): FavoriteResponse

//    @GET("favorite/{id}")
//    suspend fun getFavoriteData(@Path("id") id: Int) : FavoriteResponse
//
//    @GET("favorite")
//    suspend fun getFavorite(@Body favoriteModel: FavoritModel) : FavoriteResponse

}
