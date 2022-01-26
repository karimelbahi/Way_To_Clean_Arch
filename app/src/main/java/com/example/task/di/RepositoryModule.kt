package com.example.myutils.di

import com.example.task.data.local.daos.ProductsDao
import com.example.task.data.mapper.ProductDBMapper
import com.example.task.data.repo.ProductRepoImpl
import com.example.task.domain.repo.ProductsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        productDBMapper: ProductDBMapper,
        productsDao: ProductsDao
    ): ProductsRepo {
        return ProductRepoImpl(productDBMapper,productsDao)
    }

}