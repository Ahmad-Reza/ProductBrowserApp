package com.example.productbrowserapp.data.repository

import com.example.productbrowserapp.data.api.ProductApi
import com.example.productbrowserapp.domain.mapper.toDomain
import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return api.getProducts().map { it.toDomain() }
    }

    override suspend fun searchProducts(query: String): List<Product> {
        return api.searchProducts(query).map { it.toDomain() }
    }
}