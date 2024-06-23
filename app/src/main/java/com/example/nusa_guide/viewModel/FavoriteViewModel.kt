package com.example.nusa_guide.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.api.RetrofitInstance
import com.example.nusa_guide.api.response.FavoriteResponse
import com.example.nusa_guide.model.FavoritModel
import com.example.nusa_guide.repository.FavoriteRepository
import com.example.nusa_guide.repository.RekomendasiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: FavoriteRepository) : ViewModel() {
    private val _favorite = MutableStateFlow<List<FavoritModel>>(emptyList())
    val favorite: StateFlow<List<FavoritModel>> = _favorite.asStateFlow()

    init {
        fetchFavorite()
    }

    private fun fetchFavorite() {
        viewModelScope.launch {
            _favorite.value = repository.getFavorite()
        }
    }

    private var currentQuery = ""

    init {
        viewModelScope.launch {
            try {
                val favoriteRepository = repository.getFavorite()
                Log.d("FavoriteViewModel", "Fetched data: $favoriteRepository")
                println("jalan");
                _favorite.value = favoriteRepository
            } catch (e: Exception) {
                Log.e("FavoriteViewModel", "Error fetching data: ${e.message}")
                println("error")
            }
        }
    }



//    private val _favorite = MutableStateFlow<FavoriteResponse?>(null)
//    val favorite: StateFlow<FavoriteResponse?> get() = _favorite
//
//    init {
//        getFavorite(8)
//    }
//
//    fun getFavorite(id: Int) {
//        viewModelScope.launch {
//            try {
//                val favoriteData = RetrofitInstance.api.getFavoriteData(8)
//                _favorite.value = favoriteData
//                Log.d(TAG, "Fetched user: $favoriteData")
//            } catch (e: Exception) {
//                Log.e(TAG, "Error fetching user", e)
//            }
//
//        }
//    }
//
//    companion object {
//        private const val TAG = "FavoriteViewModel"
//    }
}

@Suppress("UNCHECKED_CAST")
class FavoriteViewModelFactory(private val repository: FavoriteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}