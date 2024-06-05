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

    private val _paketRekomendasi = MutableLiveData<List<Rekomendasi>>(emptyList())
    val paketRekomendasi: LiveData<List<Rekomendasi>> = _paketRekomendasi

    private val _rekomendasi = MutableLiveData<Rekomendasi>()
    val rekomendasi: LiveData<Rekomendasi> = _rekomendasi

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

    fun getRekomendasiById(rekomendasiId: String) {
        repository.getPaketRekomendasiById(rekomendasiId,
            onComplete = { rekomendasi ->
                // Update LiveData dengan nilai rekomendasi yang ditemukan
                _rekomendasi.postValue(rekomendasi)
            },
            onError = { exception ->
                // Penanganan kesalahan jika terjadi
                _error.value = exception.message
            }
        )
    }
}

@Suppress("UNCHECKED_CAST")
class PaketRekomendasiViewModelFactory(private val repository: RekomendasiRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RekomendasiViewModel::class.java)) {
            return RekomendasiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}