package com.example.nusa_guide.repository

import android.util.Log
import com.example.nusa_guide.api.ApiService
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.FavoritModel

class FavoriteRepository (
    private val apiService: ApiService,
    private val dataStoreManager: DataStoreManager
){
    suspend fun getFavorite(): List<FavoritModel> {
        return try {
            val token = dataStoreManager.getBearerToken() ?: ""
            val response = apiService.getFavorite("Bearer $token")
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
}