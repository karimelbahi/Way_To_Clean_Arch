package com.example.task.domain.usecases.hourlyexpireddatereprt

import com.example.task.domain.entity.Product

interface HourlyExpiredDateReportUseCase {

    suspend fun getFreshProductsSnapshot(): List<Product>
    suspend fun updateScheduledNotifications(): Int
}