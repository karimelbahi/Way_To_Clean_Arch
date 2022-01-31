package com.example.task.domain.usecases.freshproducs

import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import com.example.task.presentation.utils.currentTime
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FreshProductsUseCaseImpl @Inject constructor(
    private val repository: ProductsRepo
) : FreshProductsUseCase {

    override suspend fun getProducts(): Flow<List<Product>> {
        repository.updateAllProductsExpiredDateStatus(currentTime())
        return repository.getProducts()
    }


}