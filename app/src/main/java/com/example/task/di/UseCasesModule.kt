package com.example.task.di

import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCase
import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCaseImpl
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCase
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCaseImpl
import com.example.task.domain.usecases.scanproduct.ScanProductUseCase
import com.example.task.domain.usecases.scanproduct.ScanProductUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCasesModule {


    @Provides
    @Singleton
    fun provideExpiredProductsUseCase(
        expiredProductsUseCaseImpl: ExpiredProductsUseCaseImpl
    ): ExpiredProductsUseCase =
        expiredProductsUseCaseImpl

    @Provides
    @Singleton
    fun provideFreshProductsUseCase(
        freshProductsUseCaseImpl: FreshProductsUseCaseImpl
    ): FreshProductsUseCase =
        freshProductsUseCaseImpl

    @Provides
    @Singleton
    fun provideScanProductUseCase(
        scanProductUseCaseImpl: ScanProductUseCaseImpl
    ): ScanProductUseCase =
        scanProductUseCaseImpl


/*    @Provides
    @Singleton
    fun provideExpiredProductViewStateMapper(expiredProductViewStateMapperImpl: ExpiredProductViewStateMapperMapperImpl): ExpiredProductViewStateMapper =
        expiredProductViewStateMapperImpl*/

}