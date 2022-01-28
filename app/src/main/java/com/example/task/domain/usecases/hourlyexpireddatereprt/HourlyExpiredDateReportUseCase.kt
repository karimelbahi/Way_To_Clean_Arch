package com.example.task.domain.usecases.hourlyexpireddatereprt

import com.example.task.domain.entity.Product
import javax.inject.Singleton

@Singleton
interface HourlyExpiredDateReportUseCase {

    suspend fun getFreshProductsSnapshot(): List<Product>
    suspend fun updateScheduledNotifications(): Int
}