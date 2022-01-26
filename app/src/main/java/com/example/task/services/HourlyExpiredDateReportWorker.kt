package com.example.task.services

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.example.task.data.local.database.model.ProductDB
import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import com.example.task.presentation.utils.Constants.PRODUCT_CODE
import com.example.task.presentation.utils.Constants.PRODUCT_EXPIRED_DATE_NOTIFICATION_THREAD
import com.example.task.presentation.utils.Constants.PRODUCT_ID
import com.example.task.presentation.utils.Constants.PRODUCT_NAME
import com.example.task.presentation.utils.Constants.PRODUCT_TYPE
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

@HiltWorker
class HourlyExpiredDateReportWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted params: WorkerParameters,
    private val repository: ProductsRepo
) : Worker(context, params) {
    @ObsoleteCoroutinesApi
    override fun doWork(): Result {
        getProductExpiredDate()
        return Result.success()
    }

    @ObsoleteCoroutinesApi
    private fun getProductExpiredDate() {

        CoroutineScope(Dispatchers.IO).launch(
            newSingleThreadContext(
                PRODUCT_EXPIRED_DATE_NOTIFICATION_THREAD
            )
        ) {
            val freshProducts = repository.getFreshProductsSnapshot()
            scheduleNotification(freshProducts)
            repository.updateScheduledNotifications()
        }
    }

    private fun scheduleNotification(products: List<Product>) {
        for (product in products) {
            val expireDateWarner = product.expiredDate
            val data = Data.Builder()
                .putLong(PRODUCT_ID, product.id)
                .putString(PRODUCT_NAME, product.name)
                .putString(PRODUCT_CODE, product.code)
                .putString(PRODUCT_TYPE, product.type)
                .build()

            val currentTime = System.currentTimeMillis()

            if (expireDateWarner > currentTime) {
                val delay = expireDateWarner - currentTime
                val work = OneTimeWorkRequest
                    .Builder(ExpiredProductPushNotificationWorker::class.java)
                    .setInitialDelay(delay, TimeUnit.MILLISECONDS)
                    .setInputData(data)
                    .build()

                val workManager = WorkManager.getInstance(context)
                workManager.enqueue(work)
            } else {
                Log.i("infoLog","HourlyExpiredDateReportWorker, scheduleNotification , 69");
            }
        }
    }


}