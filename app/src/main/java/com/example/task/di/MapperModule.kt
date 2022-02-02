package com.example.task.di

import com.example.task.data.mapper.ProductDBMapper
import com.example.task.data.mapper.ProductDBMapperImpl
import com.example.task.presentation.ui.expiredproducts.mapper.ExpiredProductViewStateMapper
import com.example.task.presentation.ui.expiredproducts.mapper.ExpiredProductViewStateMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {


    @Singleton
    @Binds
    abstract fun provideProductDBMapper(productDBMapperImpl: ProductDBMapperImpl): ProductDBMapper

    @Singleton
    @Binds
    abstract  fun provideExpiredProductViewStateMapper(expiredProductViewStateMapperImpl: ExpiredProductViewStateMapperImpl): ExpiredProductViewStateMapper

}