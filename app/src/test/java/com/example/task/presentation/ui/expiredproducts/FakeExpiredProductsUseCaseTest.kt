package com.example.task.presentation.ui.expiredproducts

import com.example.task.domain.entity.Product
import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCase
import kotlinx.coroutines.flow.Flow

class FakeExpiredProductsUseCaseTest :ExpiredProductsUseCase {
    override suspend fun getExpiredProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }
}