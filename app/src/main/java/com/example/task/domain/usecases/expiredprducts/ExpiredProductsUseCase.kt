package com.example.task.domain.usecases.expiredprducts

import com.example.task.domain.entity.Product
import kotlinx.coroutines.flow.Flow

interface ExpiredProductsUseCase {

    suspend fun getExpiredProducts(): Flow<List<Product>>

}