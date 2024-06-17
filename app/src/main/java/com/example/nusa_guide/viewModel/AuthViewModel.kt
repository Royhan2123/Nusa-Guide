package com.example.nusa_guide.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


sealed class AuthState {
    data object Loading : AuthState()
    data class Success(val message: String) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel(
    private val authRepository: AuthRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    fun register(registerModel: RegisterModel) {
        viewModelScope.launch {
            try {
                _authState.value = AuthState.Loading
                val response = authRepository.register(registerModel)
                if (response.status) {
                    _authState.value = AuthState.Success(response.message)
                } else {
                    _authState.value = AuthState.Error(response.message)
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Error("An error occurred")
            }
        }
    }

    fun login(loginModel: LoginModel) {
        viewModelScope.launch {
            try {
                _authState.value = AuthState.Loading
                val response = authRepository.login(loginModel)
                if (response.status) {
                    _authState.value = AuthState.Success(response.message)
                    response.token?.let {
                        dataStoreManager.saveBearerToken(it)
                    }
                } else {
                    _authState.value = AuthState.Error(response.message)
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Error("An error occurred")
            }
        }
    }

    fun getToken(): Flow<String?> {
        return authRepository.getToken()
    }
}

class AuthViewModelFactory(
    private val authRepository: AuthRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(authRepository, dataStoreManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}