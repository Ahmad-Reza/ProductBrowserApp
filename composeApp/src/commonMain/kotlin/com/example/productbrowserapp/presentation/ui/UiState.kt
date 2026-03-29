package com.example.productbrowserapp.presentation.ui

import com.example.productbrowserapp.domain.model.Product

data class UiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
