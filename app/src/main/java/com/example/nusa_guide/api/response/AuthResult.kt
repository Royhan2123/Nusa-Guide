package com.example.nusa_guide.api.response

import com.example.nusa_guide.model.UserModel

sealed class AuthResult {
    data class Success(val data: String) : AuthResult()
    data class Error(val message: String) : AuthResult()
    data object Loading : AuthResult()
}

sealed class UserResult {
    data class Success(val data: UserModel) : UserResult()
    data class Error(val message: String) : UserResult()
}