package com.example.nusa_guide.api.response

sealed class AuthResult {
    data class Success(val data: String) : AuthResult()
    data class Error(val message: String) : AuthResult()

    data object Loading : AuthResult()
}
