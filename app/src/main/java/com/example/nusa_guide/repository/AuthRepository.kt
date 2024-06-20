package com.example.nusa_guide.repository

import android.util.Log
import com.example.nusa_guide.api.ApiService
import com.example.nusa_guide.api.response.AuthResult
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.model.UserModel


class AuthRepository(
    private val apiService: ApiService,
    private val dataStoreManager: DataStoreManager
) {
    suspend fun login(loginModel: LoginModel): AuthResult {
        return try {
            val response = apiService.login(loginModel)
            if (response.status) {
                val token = response.token.removePrefix("Bearer ")
                dataStoreManager.saveBearerToken(token)
                dataStoreManager.saveUserId(response.data.id ?: 0) // Simpan ID pengguna, default 0 jika null
                AuthResult.Success(response.message)
            } else {
                AuthResult.Error(response.message)
            }
        } catch (e: Exception) {
            Log.e("AuthRepository", "Login failed", e)
            AuthResult.Error("Login failed. Please try again.")
        }
    }

    suspend fun register(registerModel: RegisterModel): AuthResult {
        return try {
            val response = apiService.register(registerModel)
            if (response.message == "Register Success") {
                AuthResult.Success(response.message)
            } else {
                AuthResult.Error(response.message)
            }
        } catch (e: Exception) {
            AuthResult.Error("Register failed. Please try again.")
        }
    }

    suspend fun getBearerToken(): String? {
        return dataStoreManager.getBearerToken()
    }

    suspend fun getUserId(): Int? {
        return dataStoreManager.getUserId()
    }

    suspend fun getUser(userId: Int): UserModel? {
        return try {
            Log.d("AuthRepository", "Fetching user with ID: $userId")
            apiService.getUser(userId)
        } catch (e: Exception) {
            Log.e("AuthRepository", "Failed to fetch user", e)
            null
        }
    }
}