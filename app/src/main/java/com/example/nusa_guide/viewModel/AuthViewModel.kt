package com.example.nusa_guide.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.api.response.AuthResult
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.model.UserModel
import com.example.nusa_guide.repository.AuthRepository
import kotlinx.coroutines.launch


class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _registerResult = MutableLiveData<AuthResult>()
    val registerResult: LiveData<AuthResult> = _registerResult

    private val _loginResult = MutableLiveData<AuthResult>()
    val loginResult: LiveData<AuthResult> = _loginResult

    private val _user = MutableLiveData<UserModel?>()
    val user: LiveData<UserModel?> = _user

    private val _userId = MutableLiveData<Int?>()
    val userId: LiveData<Int?> = _userId

    init {
        viewModelScope.launch {
            try {
                val userId = repository.getUserId()
                _userId.postValue(userId)
                if (userId != null) {
                    fetchUser()
                } else {
                    Log.e("AuthViewModel", "User ID is null")
                }
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Failed to get user ID", e)
            }
        }
    }

    suspend fun fetchUser() {
        try {
            val token = repository.getBearerToken() ?: return
            val user = repository.getUser(token)
            _user.postValue(user)
        } catch (e: Exception) {
            Log.e("AuthViewModel", "Failed to fetch user", e)
            _user.postValue(null)
        }
    }

    // Mendapatkan bearer token dari DataStoreManager
    suspend fun getBearerToken(): String? {
        return repository.getBearerToken()
    }

    fun register(registerModel: RegisterModel) {
        viewModelScope.launch {
            try {
                _registerResult.value = AuthResult.Loading
                val result = repository.register(registerModel)
                _registerResult.value = result
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Registration failed", e)
                _registerResult.value = AuthResult.Error("Registration failed")
            }
        }
    }

    fun login(loginModel: LoginModel) {
        viewModelScope.launch {
            try {
                _loginResult.value = AuthResult.Loading
                val result = repository.login(loginModel)
                _loginResult.value = result
                if (result is AuthResult.Success) {
                    val userId = repository.getUserId() ?: 0
                    fetchUser()
                    _userId.postValue(userId)
                }
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Login failed", e)
                _loginResult.value = AuthResult.Error("Login failed")
            }
        }
    }
}

class AuthViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}