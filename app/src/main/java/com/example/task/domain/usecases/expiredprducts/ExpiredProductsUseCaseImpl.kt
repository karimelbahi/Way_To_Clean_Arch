package com.example.task.domain.usecases.expiredprducts

import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpiredProductsUseCaseImpl @Inject constructor(
    private val repository: ProductsRepo
) : ExpiredProductsUseCase {

    override suspend fun getExpiredProducts(): Flow<List<Product>> = repository.getExpiredProducts()

}