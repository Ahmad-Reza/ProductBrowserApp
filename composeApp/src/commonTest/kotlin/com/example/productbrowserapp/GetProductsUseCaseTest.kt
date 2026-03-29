package com.example.productbrowserapp

import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.repository.ProductRepository
import com.example.productbrowserapp.domain.usercase.GetProductsUseCase
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetProductsUseCaseTest {

    @Test
    fun testGetProducts() = runTest {
        val fakeRepo = object : ProductRepository {
            override suspend fun getProducts() =
                listOf(Product(1, "Test", "desc", "brand", 10.0, 4.0, ""))

            override suspend fun searchProducts(query: String) =
                emptyList<Product>()
        }

        val useCase = GetProductsUseCase(fakeRepo)

        val result = useCase()

        assertTrue(result.isNotEmpty())
        assertTrue(result[0].title == "Test")
    }
}
