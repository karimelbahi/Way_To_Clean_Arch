package com.example.task.di

import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCase
import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCaseImpl
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


//    @Provides
//    @Singleton
//    fun provideExpiredProductViewStateMapper(expiredProductViewStateMapperImpl: ExpiredProductViewStateMapperMapperImpl): ExpiredProductViewStateMapper =
//        expiredProductViewStateMapperImpl

}