package com.example.nusa_guide.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nusa_guide.model.Rekomendasi
import com.example.nusa_guide.repository.RekomendasiRepository

class RekomendasiViewModel(
    private val repository: RekomendasiRepository
) : ViewModel() {

    private val _paketRekomendasi = MutableLiveData<List<Rekomendasi>>()
    val paketRekomendasi: LiveData<List<Rekomendasi>> = _paketRekomendasi

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        fetchPaketRekomendasi()
    }

    private fun fetchPaketRekomendasi() {
        repository.getPaketRekomendasi(
            onComplete = { rekomendasiList ->
                _paketRekomendasi.value = rekomendasiList
            },
            onError = { exception ->
                _error.value = exception.message
            }
        )
    }
}

@Suppress("UNCHECKED_CAST")
class PaketRekomendasiViewModelFactory(private val repository: RekomendasiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RekomendasiViewModel::class.java)) {
            return RekomendasiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}