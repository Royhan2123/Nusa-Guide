package com.example.nusa_guide.repository

import com.example.nusa_guide.Api.ApiService
import com.example.nusa_guide.Api.response.LoginResponse
import com.example.nusa_guide.Api.response.RegisterResponse
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import kotlinx.coroutines.flow.Flow

class AuthRepository(
    private val apiService: ApiService,
    private val dataStoreManager: DataStoreManager
) {

    suspend fun register(registerModel: RegisterModel): RegisterResponse {
        return apiService.register(registerModel)
    }

    suspend fun login(loginModel: LoginModel): LoginResponse {
        val response = apiService.login(loginModel)
        response.token?.let { dataStoreManager.saveBearerToken(it) }
        return response
    }

    fun getToken(): Flow<String?> {
        return dataStoreManager.bearerToken
    }
}