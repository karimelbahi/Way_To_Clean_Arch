package com.example.task.domain.usecases.hourlyexpireddatereprt

import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HourlyExpiredDateReportUseCaseImpl @Inject constructor(
    private val repository: ProductsRepo
) : HourlyExpiredDateReportUseCase {


    override suspend fun getFreshProductsSnapshot(): List<Product> =
        repository.getProducts().first()


    override suspend fun updateScheduledNotifications(): Int =
        repository.updateScheduledNotifications()
}