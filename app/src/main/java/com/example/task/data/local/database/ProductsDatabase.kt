package com.example.task.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task.data.local.daos.ProductsDao
import com.example.task.data.local.database.model.ProductDB

@Database(entities = [ProductDB::class], version = 2, exportSchema = false)
abstract class ProductsDatabase : RoomDatabase() {

    abstract fun productsDao(): ProductsDao

}