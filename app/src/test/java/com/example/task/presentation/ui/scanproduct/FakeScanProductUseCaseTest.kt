package com.example.task.presentation.ui.scanproduct

import com.example.task.domain.entity.Product
import com.example.task.domain.usecases.scanproduct.ScanProductUseCase

class FakeScanProductUseCaseTest : ScanProductUseCase {
    override suspend fun insertProduct(product: Product): Long {
        TODO("Not yet implemented")
    }
}