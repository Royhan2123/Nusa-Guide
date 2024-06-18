package com.example.nusa_guide.repository

import com.example.nusa_guide.api.ApiService
import com.example.nusa_guide.api.response.AuthResult
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel


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
}