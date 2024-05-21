package com.example.nusa_guide.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nusa_guide.R
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn


class SearchViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _product = MutableStateFlow(items)

    @OptIn(FlowPreview::class)
    val products = searchText
        .debounce(1000L)
        .onEach { _isSearching.value = true }
        .combine(_product) { text, product ->
            if (text.isBlank()) {
                product
            } else {
                delay(2000L)
                product.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.value = false }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _product.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

val items = listOf(
    SearchItemList(
        nameTour = "Paket Tour Bali 1 Bedugul",
        image = R.drawable.image_begudul,
        detail1 = "Pura Ulun Danu Beratan",
        detail2 = "Agrowisata Kopi Luwak",
        detail3 = "Cocoa Land",
        detail4 = "Pura Tanah Lot",
        hargaTour = "535.000",
        diskon = "25%",
        hargaAsli = "600.00",
    ),
    SearchItemList(
        nameTour = "Paket Tour Bali 1 Bedugul",
        image = R.drawable.image_begudul,
        detail1 = "Pura Ulun Danu Beratan",
        detail2 = "Agrowisata Kopi Luwak",
        detail3 = "Cocoa Land",
        detail4 = "Pura Tanah Lot",
        hargaTour = "535.000",
        diskon = "25%",
        hargaAsli = "600.00",

    ),
    SearchItemList(
        nameTour = "Paket Tour Bali 1 Bedugul",
        image = R.drawable.image_begudul,
        detail1 = "Pura Ulun Danu Beratan",
        detail2 = "Agrowisata Kopi Luwak",
        detail3 = "Cocoa Land",
        detail4 = "Pura Tanah Lot",
        hargaTour = "535.000",
        diskon = "25%",
        hargaAsli = "600.00",

    ),
    SearchItemList(
        nameTour = "Paket Tour Bali 1 Bedugul",
        image = R.drawable.image_begudul,
        detail1 = "Pura Ulun Danu Beratan",
        detail2 = "Agrowisata Kopi Luwak",
        detail3 = "Cocoa Land",
        detail4 = "Pura Tanah Lot",
        hargaTour = "535.000",
        diskon = "25%",
        hargaAsli = "600.00",

    ),
)