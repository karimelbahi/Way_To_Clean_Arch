package com.example.task.domain.usecases.freshproducs

import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import com.example.task.presentation.utils.currentTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class FreshProductsUseCaseImpl @Inject constructor(
    private val repository: ProductsRepo
) : FreshProductsUseCase {

    override suspend fun updateAllProductsExpiredDateStatus() =
        repository.updateAllProductsExpiredDateStatus(currentTime())


    override suspend fun getProducts(): Flow<List<Product>> =
        repository.getProducts()


    override suspend fun getFreshProductsSnapshot(): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun updateScheduledNotifications(): Int {
        TODO("Not yet implemented")
    }
}