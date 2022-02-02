package com.example.task.domain.usecases.scanproduct

import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import javax.inject.Inject

class ScanProductUseCaseImpl @Inject constructor(
    private val repository: ProductsRepo
) : ScanProductUseCase {
    override suspend fun insertProduct(product: Product): Long =
        repository.insertProduct(product)

}