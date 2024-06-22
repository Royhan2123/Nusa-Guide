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

    suspend fun getWisataDetail(id: Int): WisataModel? {
        return try {
            val token = dataStoreManager.getBearerToken() ?: ""
            val response = apiService.getRekomendasi("Bearer $token")
            response.data.find { it.id == id }
        } catch (e: Exception) {
            Log.e("RekomendasiRepository", "Error fetching data: ${e.message}")
            null
        }
    }

    suspend fun getWisataByKategori(kategori: String): List<WisataModel> {
        return try {
            val token = dataStoreManager.getBearerToken() ?: ""
            val response = apiService.getWisataByKategori("Bearer $token", kategori)
            if (response.message.contains("Berhasil")) {
                response.data
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("RekomendasiRepository", "Error fetching data: ${e.message}")
            emptyList()
        }
    }

    suspend fun getWisataByRating(rating: Int): List<WisataModel> {
        return try {
            val token = dataStoreManager.getBearerToken() ?: ""
            val response = apiService.getWisataByRating("Bearer $token", rating)
            if (response.message.contains("Berhasil")) {
                Log.d("getRatingRepository", "data rating: ${response.message}")
                response.data
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            Log.e("getRatingRepository", "Error fetching data: ${e.message}")
            emptyList()
        }
    }
}
