package com.example.nusa_guide.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.repository.RekomendasiRepository
import kotlinx.coroutines.launch

class RekomendasiViewModel(private val repository: RekomendasiRepository) : ViewModel() {
    private val _rekomendasiItems = MutableLiveData<List<Rekomendasi>>()
    val rekomendasiItems: LiveData<List<Rekomendasi>> get() = _rekomendasiItems

    init {
        viewModelScope.launch {
            _rekomendasiItems.value = repository.getRekomendasi()
        }
    }
}