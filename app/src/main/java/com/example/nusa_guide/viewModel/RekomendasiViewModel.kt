package com.example.nusa_guide.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.model.RekomendasiModel
import com.example.nusa_guide.repository.RekomendasiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RekomendasiViewModel(private val repository: RekomendasiRepository) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<RekomendasiModel>())
    val state: StateFlow<List<RekomendasiModel>> = _state

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

    fun fetchRekomendasiById(id: Int) {
        viewModelScope.launch {
            try {
                val rekomendasiRepository = repository.getRekomendasiById(id)
                if (rekomendasiRepository != null) {
                    _state.value = listOf(rekomendasiRepository)
                } else {
                    _state.value = emptyList()
                    Log.d("RekomendasiViewModel", "Data not found for ID: $id")
                }
            } catch (e: Exception) {
                Log.e("RekomendasiViewModel", "Error fetching data by ID: ${e.message}")
            }
        }
    }
}
@Suppress("UNCHECKED_CAST")
class RekomendasiViewModelFactory(private val repository: RekomendasiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RekomendasiViewModel::class.java)) {
            return RekomendasiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}