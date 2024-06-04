package com.example.nusa_guide.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.repository.AuthRepository

sealed class AuthState {
   data object Authenticated : AuthState()
    data class Error(val message: String) : AuthState()
    data object Loading : AuthState()
    data object Logout : AuthState()
}

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    fun registerUser(registerModel: RegisterModel) {
        _authState.value = AuthState.Loading
        authRepository.registerUser(registerModel) { success, message ->
            if (success) {
                _authState.value = AuthState.Authenticated
            } else {
                _authState.value = AuthState.Error(message ?: "Registration failed")
            }
        }
    }

    fun loginUser(loginModel: LoginModel) {
        _authState.value = AuthState.Loading
        authRepository.loginUser(loginModel) { success, message ->
            if (success) {
                _authState.value = AuthState.Authenticated
            } else {
                _authState.value = AuthState.Error(message ?: "Login failed")
            }
        }
    }

    fun authLogout() {
        authRepository.authLogout()
        _authState.value = AuthState.Logout
    }
    fun getSavedCredentials(): Pair<String, String>? {
        return authRepository.getSavedCredentials()
    }
}
