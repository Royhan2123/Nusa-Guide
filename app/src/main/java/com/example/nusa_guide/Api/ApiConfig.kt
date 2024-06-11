package com.example.nusa_guide.Api

import com.example.nusa_guide.CONSTANT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConfig {
    fun getApiService(): ApiServices {
        return Retrofit.Builder()
            .baseUrl(CONSTANT.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }
}