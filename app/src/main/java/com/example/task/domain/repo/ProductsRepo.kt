package com.example.task.domain.repo

import com.example.task.data.local.database.model.ProductDB
import com.example.task.domain.entity.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface ProductsRepo {

    // home
//    suspend fun checkProductsExpiredDateStatus(): Flow<List<Product>>
    suspend fun updateAllProductsExpiredDateStatus(currentTime :Long): Unit
    suspend fun getProducts(): Flow<List<Product>>
    suspend fun getFreshProductsSnapshot(): List<Product>
    suspend fun updateScheduledNotifications(): Int


    // scan product
    suspend fun insertProduct(product: Product): Long


    // expired product
    suspend fun getExpiredProducts(): Flow<List<Product>>


}