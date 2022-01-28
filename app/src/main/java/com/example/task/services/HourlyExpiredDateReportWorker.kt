package com.example.task.services

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.example.task.data.local.database.model.ProductDB
import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import com.example.task.domain.usecases.hourlyexpireddatereprt.HourlyExpiredDateReportUseCase
import com.example.task.presentation.utils.Constants.PRODUCT
import com.example.task.presentation.utils.Constants.PRODUCT_CODE
import com.example.task.presentation.utils.Constants.PRODUCT_EXPIRED_DATE_NOTIFICATION_THREAD
import com.example.task.presentation.utils.Constants.PRODUCT_ID
import com.example.task.presentation.utils.Constants.PRODUCT_NAME
import com.example.task.presentation.utils.Constants.PRODUCT_TYPE
import com.google.gson.Gson
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltWorker
class HourlyExpiredDateReportWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted params: WorkerParameters,
    private val gson: Gson,
    private val hourlyExpiredDateReportUseCase: HourlyExpiredDateReportUseCase
) : Worker(context, params) {

    override fun doWork(): Result {
        getProductExpiredDate()
        return Result.success()
    }


    private fun getProductExpiredDate() {

        CoroutineScope(Dispatchers.IO).launch {
            val freshProducts = hourlyExpiredDateReportUseCase.getFreshProductsSnapshot()
            scheduleNotification(freshProducts)
            hourlyExpiredDateReportUseCase.updateScheduledNotifications()
        }

    }

    private fun scheduleNotification(products: List<Product>) {
        for (product in products) {
            val expireDateWarner = product.expiredDate

            val strProduct = gson.toJson(product)

            val data = Data.Builder()
                .putString(PRODUCT, strProduct)
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
                Log.i("infoLog", "HourlyExpiredDateReportWorker, scheduleNotification , 69");
            }
        }
    }


}