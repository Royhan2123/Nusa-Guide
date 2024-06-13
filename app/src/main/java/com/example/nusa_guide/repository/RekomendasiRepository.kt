package com.example.nusa_guide.repository

import com.example.nusa_guide.Api.RetrofitInstance
import com.example.nusa_guide.model.Rekomendasi

class RekomendasiRepository {
    suspend fun getRekomendasi(): List<Rekomendasi> {
        return try {
            val response = RetrofitInstance.api.getRekomendasi()
            if (response.message == "GET all wisata success!") {
                response.data
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}