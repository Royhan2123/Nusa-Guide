package com.example.nusa_guide.repository

import android.util.Log
import com.example.nusa_guide.api.ApiService
import com.example.nusa_guide.api.response.AuthResult
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.viewModel.UserResult


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

    suspend fun getUser(): UserResult {
        return try {
            val token = "Bearer " + dataStoreManager.getBearerToken()
            val response = apiService.getUser(token)
            if (response.message == "Data user Berhasil Diambil!") {
                UserResult.Success(response.data[0])
            } else {
                UserResult.Error(response.message)
            }
        } catch (e: Exception) {
            Log.e("AuthRepository", "Get user failed", e)
            UserResult.Error("Get user failed. Please try again.")
        }
    }

    suspend fun logout(): AuthResult {
        return try {
            val token = "Bearer " + dataStoreManager.getBearerToken()
            val response = apiService.logout(token)
            if (response.success) {
                dataStoreManager.clearBearerToken()  // Hapus token dari DataStore
                AuthResult.Success(response.message)
            } else {
                AuthResult.Error(response.message)
            }
        } catch (e: Exception) {
            Log.e("AuthRepository", "Logout failed", e)
            AuthResult.Error("Logout failed. Please try again.")
        }
    }

}