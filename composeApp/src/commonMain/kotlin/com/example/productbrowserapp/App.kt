package com.example.productbrowserapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.productbrowserapp.di.AppModule
import com.example.productbrowserapp.presentation.ui.ProductDetailScreen
import com.example.productbrowserapp.presentation.ui.ProductListScreen

@Composable
fun App() {
    val viewModel = remember { AppModule.viewModel }
    val selectedProduct by viewModel.selectedProduct.collectAsState()

    MaterialTheme {
        if (selectedProduct == null) {
            ProductListScreen(viewModel)
        } else {
            ProductDetailScreen(
                product = selectedProduct!!,
                onBack = { viewModel.selectProduct(null) }
            )
        }
    }
}
