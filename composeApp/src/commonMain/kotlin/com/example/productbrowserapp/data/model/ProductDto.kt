package com.example.productbrowserapp.data.model

@kotlinx.serialization.Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val description: String? = null,
    val brand: String? = null,
    val price: Double,
    val rating: Double? = null,
    val thumbnail: String? = null
)