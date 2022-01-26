package com.example.task.data

import com.example.task.data.local.database.model.ProductDB
import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.Flow

class FakeScanProductRepoTest :ProductsRepo {

    override suspend fun checkProductsExpiredDateStatus() {
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