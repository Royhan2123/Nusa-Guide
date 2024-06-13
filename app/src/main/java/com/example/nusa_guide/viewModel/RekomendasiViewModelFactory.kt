package com.example.nusa_guide.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nusa_guide.repository.RekomendasiRepository

@Suppress("UNCHECKED_CAST")
class RekomendasiViewModelFactory(private val repository: RekomendasiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RekomendasiViewModel::class.java)) {
            return RekomendasiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}