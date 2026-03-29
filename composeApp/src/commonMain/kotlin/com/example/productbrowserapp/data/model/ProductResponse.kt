package com.example.productbrowserapp.data.model

@kotlinx.serialization.Serializable
data class ProductResponse(
    val products: List<ProductDto>
)