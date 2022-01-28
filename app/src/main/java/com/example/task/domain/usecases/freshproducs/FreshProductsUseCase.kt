package com.example.task.domain.usecases.freshproducs

import com.example.task.domain.entity.Product
import kotlinx.coroutines.flow.Flow

interface FreshProductsUseCase {

    suspend fun updateAllProductsExpiredDateStatus(): Unit
    suspend fun getProducts(): Flow<List<Product>>

    // work manager use case
    suspend fun getFreshProductsSnapshot(): List<Product>
    suspend fun updateScheduledNotifications(): Int
}