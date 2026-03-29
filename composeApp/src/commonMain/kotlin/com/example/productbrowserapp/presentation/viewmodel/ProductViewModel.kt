package com.example.productbrowserapp.presentation.viewmodel

import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.usercase.GetProductsUseCase
import com.example.productbrowserapp.domain.usercase.SearchProductsUseCase
import com.example.productbrowserapp.presentation.ui.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProducts: GetProductsUseCase,
    private val searchProducts: SearchProductsUseCase
) {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct

    private var searchJob: Job? = null

    fun loadProducts() {
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            try {
                val result = getProducts()
                _state.value = UiState(products = result)
            } catch (e: Exception) {
                _state.value = UiState(error = "Failed to load products: ${e.message}")
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (query.isBlank()) {
                loadProducts()
                return@launch
            }
            
            delay(500) // Debounce search
            _state.value = _state.value.copy(isLoading = true)
            try {
                val result = searchProducts(query)
                _state.value = UiState(products = result)
            } catch (e: Exception) {
                _state.value = UiState(error = "Search failed: ${e.message}")
            }
        }
    }

    fun selectProduct(product: Product?) {
        _selectedProduct.value = product
    }
}
