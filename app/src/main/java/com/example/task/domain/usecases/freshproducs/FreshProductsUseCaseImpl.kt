package com.example.task.domain.usecases.freshproducs

import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import com.example.task.presentation.utils.currentTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class FreshProductsUseCaseImpl @Inject constructor(
    private val repository: ProductsRepo
) : FreshProductsUseCase {

    override suspend fun updateAllProductsExpiredDateStatus() =
        repository.updateAllProductsExpiredDateStatus(currentTime())


    override suspend fun getProducts(): Flow<List<Product>> =
        repository.getProducts()



}