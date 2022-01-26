package com.example.task.di

import android.content.Context
import androidx.room.Room
import com.example.task.data.local.daos.ProductsDao
import com.example.task.data.local.database.ProductsDatabase
import com.example.task.presentation.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ProductsDatabase {
        return Room
            .databaseBuilder(context, ProductsDatabase::class.java, Constants.LOCAL_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideAppDao(appDatabase: ProductsDatabase): ProductsDao {
        return appDatabase.productsDao()
    }
}