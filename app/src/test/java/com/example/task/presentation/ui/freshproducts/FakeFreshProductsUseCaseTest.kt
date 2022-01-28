package com.example.task.presentation.ui.freshproducts

import com.example.task.domain.entity.Product
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCase
import kotlinx.coroutines.flow.Flow

class FakeFreshProductsUseCaseTest : FreshProductsUseCase {
    override suspend fun updateAllProductsExpiredDateStatus() {
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
}