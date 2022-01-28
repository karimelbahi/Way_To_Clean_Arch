package com.example.task.data

import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.Flow

class ProductRepoTest : ProductsRepo {

    override suspend fun updateAllProductsExpiredDateStatus(currentTime: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFreshProductsSnapshot(): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun updateScheduledNotifications(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getExpiredProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertProduct(product: Product): Long {
        TODO("Not yet implemented")
    }
}