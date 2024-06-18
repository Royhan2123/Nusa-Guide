package com.example.nusa_guide.repository

import android.util.Log
import com.example.nusa_guide.api.ApiService
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.WisataModel

class RekomendasiRepository(
    private val apiService: ApiService,
    private val dataStoreManager: DataStoreManager
) {

    suspend fun getRekomendasi(): List<WisataModel> {
        return try {
            val token = dataStoreManager.getBearerToken() ?: ""
            val response = apiService.getRekomendasi("Bearer $token")
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
            val token = dataStoreManager.getBearerToken() ?: ""
            val response = apiService.getRekomendasi("Bearer $token")
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