package com.example.nusa_guide.repository

import android.util.Log
import com.example.nusa_guide.Api.RetrofitInstance
import com.example.nusa_guide.model.RekomendasiModel

class RekomendasiRepository {
    suspend fun getRekomendasi(): List<RekomendasiModel> {
        return try {
            val response = RetrofitInstance.api.getRekomendasi()
            if (response.message == "GET all wisata success!") {
                response.data
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("RekomendasiRepository", "Error fetching data: ${e.message}")
            emptyList()
        }
    }
    suspend fun getRekomendasiById(id: Int): RekomendasiModel? {
        return try {
            val response = RetrofitInstance.api.getRekomendasiById(id)
            if (response.message == "Data wisata Dengan ID:$id Berhasil Diambil!") {
                response.data.getOrNull(0)
            } else {
                null
            }
        } catch (e: Exception) {
            Log.e("RekomendasiRepository", "Error fetching data by ID: ${e.message}")
            null
        }
    }
}
