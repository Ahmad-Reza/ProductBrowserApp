package com.example.productbrowserapp.di

import com.example.productbrowserapp.data.api.ProductApi
import com.example.productbrowserapp.data.repository.ProductRepositoryImpl
import com.example.productbrowserapp.domain.usercase.GetProductsUseCase
import com.example.productbrowserapp.domain.usercase.SearchProductsUseCase
import com.example.productbrowserapp.presentation.viewmodel.ProductViewModel

object AppModule {

    private val client = provideHttpClient()

    private val api = ProductApi(client)

    private val repository = ProductRepositoryImpl(api)

    val getProductsUseCase = GetProductsUseCase(repository)
    val searchProductsUseCase = SearchProductsUseCase(repository)

    val viewModel = ProductViewModel(
        getProductsUseCase,
        searchProductsUseCase
    )
}
