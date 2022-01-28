package com.example.task.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.task.data.local.database.model.ProductDB
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productDB: ProductDB): Long

    @Query("SELECT * FROM PRODUCT_TABLE WHERE expired = 0 ORDER BY expiredDate ASC")
    fun getFreshProducts(): Flow<List<ProductDB>>

//    @Query("SELECT * FROM PRODUCT_TABLE WHERE expired = 0 AND warningNotificationScheduled=0")
//    fun getFreshProducts(): List<ProductDB>

    @Query("SELECT * FROM PRODUCT_TABLE WHERE expired = 1")
    fun getExpiredProducts(): Flow<List<ProductDB>>

//    @Query("SELECT * FROM PRODUCT_TABLE WHERE expired = 0")
//    fun checkProductsExpiredDateStatus(): List<ProductDB>

    @Query("UPDATE PRODUCT_TABLE SET expired = :expired WHERE id =:id")
    fun updateProductsExpiredDateStatus(id: Long, expired: Boolean = true): Int

    // TODO: 1/27/2022 expiredate more that curernt date 
    @Query("UPDATE PRODUCT_TABLE SET expired = :expired WHERE  expiredDate <:currentTime ")
    fun updateAllProductsExpiredDateStatus(expired: Boolean = true, currentTime: Long): Int

//    @Query("UPDATE PRODUCT_TABLE SET expiredDate = :expiredDate WHERE id =:id")
//    suspend fun updateProductExpireDate(id: Long, expiredDate: Long): Int

    @Query("UPDATE  PRODUCT_TABLE SET warningNotificationScheduled =:scheduled  WHERE warningNotificationScheduled = 0")
    fun updateScheduledNotifications(scheduled: Boolean = true): Int


}