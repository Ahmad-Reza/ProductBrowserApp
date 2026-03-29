package com.example.productbrowserapp.domain.mapper

import com.example.productbrowserapp.data.model.ProductDto
import com.example.productbrowserapp.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description ?: "",
        brand = brand ?: "Unknown",
        price = price,
        rating = rating ?: 0.0,
        thumbnail = thumbnail ?: ""
    )
}