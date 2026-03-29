package com.example.productbrowserapp.data.api

import com.example.productbrowserapp.data.model.ProductDto
import com.example.productbrowserapp.data.model.ProductResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ProductApi(private val client: HttpClient) {

    suspend fun getProducts(): List<ProductDto> {
        val response: ProductResponse =
            client.get("https://dummyjson.com/products").body()
        return response.products
    }

    suspend fun searchProducts(query: String): List<ProductDto> {
        val response: ProductResponse =
            client.get("https://dummyjson.com/products/search?q=$query").body()
        return response.products
    }
}