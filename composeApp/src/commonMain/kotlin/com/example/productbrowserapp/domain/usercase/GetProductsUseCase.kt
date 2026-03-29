package com.example.productbrowserapp.domain.usercase

import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.repository.ProductRepository

class GetProductsUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> {
        return repository.getProducts()
    }
}