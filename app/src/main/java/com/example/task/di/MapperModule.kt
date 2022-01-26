package com.example.task.di

import com.example.task.data.mapper.ProductDBMapper
import com.example.task.data.mapper.ProductDBMapperImpl
import com.example.task.presentation.ui.expiredproducts.mapper.ExpiredProductViewStateMapper
import com.example.task.presentation.ui.expiredproducts.mapper.ExpiredProductViewStateMapperMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideProductDBMapper(productDBMapperImpl: ProductDBMapperImpl): ProductDBMapper =
        productDBMapperImpl


    @Provides
    @Singleton
    fun provideExpiredProductViewStateMapper(expiredProductViewStateMapperImpl: ExpiredProductViewStateMapperMapperImpl): ExpiredProductViewStateMapper =
        expiredProductViewStateMapperImpl

}