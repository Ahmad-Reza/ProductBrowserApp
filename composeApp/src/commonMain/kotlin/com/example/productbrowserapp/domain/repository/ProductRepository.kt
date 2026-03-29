package com.example.productbrowserapp.domain.repository

import com.example.productbrowserapp.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun searchProducts(query: String): List<Product>
}