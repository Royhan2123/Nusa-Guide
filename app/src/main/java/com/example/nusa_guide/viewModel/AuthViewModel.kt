package com.example.nusa_guide.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.Api.response.LoginResponse
import com.example.nusa_guide.Api.response.RegisterResponse
import com.example.nusa_guide.data.DataStoreManager
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.example.nusa_guide.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _registerResult = MutableLiveData<RegisterResponse>()
    val registerResult: LiveData<RegisterResponse> = _registerResult

    private val _loginResult = MutableLiveData<LoginResponse>()
    val loginResult: LiveData<LoginResponse> = _loginResult

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun register(registerModel: RegisterModel) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = authRepository.register(registerModel)
                _registerResult.postValue(response)
            } catch (e: Exception) {
                // Handle error
                throw e
            } finally {
                _loading.value = false
            }
        }
    }

    fun login(loginModel: LoginModel) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = authRepository.login(loginModel)
                _loginResult.postValue(response)

                // Save bearer token if login successful
                if (response.status) {
                    response.token?.let {
                        dataStoreManager.saveBearerToken(it)
                    }
                }
            } catch (e: Exception) {
                // Handle error
                throw e
            } finally {
                _loading.value = false
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