package com.example.task.domain.usecases.scanproduct

import com.example.task.domain.entity.Product

interface ScanProductUseCase {

    suspend fun insertProduct(product: Product): Long

}