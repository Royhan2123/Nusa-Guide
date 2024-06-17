package com.example.nusa_guide.repository

import android.util.Log
import com.example.nusa_guide.Api.RetrofitInstance
import com.example.nusa_guide.model.WisataModel

class RekomendasiRepository {
    suspend fun getRekomendasi(): List<WisataModel> {
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
    suspend fun searchRekomendasi(query: String): List<WisataModel> {
        return try {
            val response = RetrofitInstance.api.getRekomendasi()
            if (response.message == "GET all wisata success!") {
                response.data.filter { rekomendasi ->
                    rekomendasi.nama?.contains(query, ignoreCase = true) ?: false
                }
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("RekomendasiRepository", "Error fetching data: ${e.message}")
            emptyList()
        }
    }
}
