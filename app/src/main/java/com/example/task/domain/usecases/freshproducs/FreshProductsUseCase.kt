package com.example.task.domain.usecases.freshproducs

import com.example.task.domain.entity.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton


interface FreshProductsUseCase {

    suspend fun getProducts(): Flow<List<Product>>

}