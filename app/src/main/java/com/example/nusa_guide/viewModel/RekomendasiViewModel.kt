package com.example.nusa_guide.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.model.WisataModel
import com.example.nusa_guide.repository.RekomendasiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RekomendasiViewModel(private val repository: RekomendasiRepository) : ViewModel() {
    private val _state = MutableStateFlow<List<WisataModel>>(emptyList())
    val state: StateFlow<List<WisataModel>> = _state.asStateFlow()

    fun getWisataByKategori(kategori: String) {
        viewModelScope.launch {
            try {
                val result = repository.getWisataByKategori(kategori)
                _state.value = result
            } catch (e: Exception) {
                Log.e("RekomendasiViewModel", "Error fetching data: ${e.message}")
            }
        }
    }

    init {
        fetchRekomendasi()
    }

    private fun fetchRekomendasi() {
        viewModelScope.launch {
            _state.value = repository.getRekomendasi()
        }
    }

    private var currentQuery = ""

    init {
        viewModelScope.launch {
            try {
                val rekomendasiRepository = repository.getRekomendasi()
                Log.d("RekomendasiViewModel", "Fetched data: $rekomendasiRepository")
                _state.value = rekomendasiRepository
            } catch (e: Exception) {
                Log.e("RekomendasiViewModel", "Error fetching data: ${e.message}")
            }
        }
    }

    fun searchRekomendasi(query: String) {
        currentQuery = query
        viewModelScope.launch {
            try {
                val rekomendasiRepository = repository.searchRekomendasi(query)
                _state.value = rekomendasiRepository
            } catch (e: Exception) {
                Log.e("RekomendasiViewModel", "Error searching data: ${e.message}")
            }
        }
    }

    suspend fun getWisataDetail(id: Int): WisataModel? {
        return repository.getWisataDetail(id)
    }

    fun getWisataByRating(rating: Int) {
        viewModelScope.launch {
            try {
                val result = repository.getWisataByRating(rating)
                _state.value = result
            } catch (e: Exception) {
                Log.e("getRatingViewModel ", "Error fetching data: ${e.message}")
            }
        }
    }
}


@Suppress("UNCHECKED_CAST")
class RekomendasiViewModelFactory(private val repository: RekomendasiRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RekomendasiViewModel::class.java)) {
            return RekomendasiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}