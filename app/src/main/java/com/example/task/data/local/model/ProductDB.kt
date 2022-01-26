package com.example.task.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.task.presentation.utils.Constants

@Entity(tableName = Constants.PRODUCT_TABLE)
data class ProductDB(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "expiredDate")
    var expiredDate: Long,
    @ColumnInfo(name = "expired")
    var isExpired: Boolean = false,
    @ColumnInfo(name = "warningNotificationScheduled")
    var isWarningNotificationScheduled: Boolean = false
)