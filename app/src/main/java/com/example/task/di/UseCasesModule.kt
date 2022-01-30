package com.example.task.di

import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCase
import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCaseImpl
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCase
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCaseImpl
import com.example.task.domain.usecases.hourlyexpireddatereprt.HourlyExpiredDateReportUseCase
import com.example.task.domain.usecases.hourlyexpireddatereprt.HourlyExpiredDateReportUseCaseImpl
import com.example.task.domain.usecases.scanproduct.ScanProductUseCase
import com.example.task.domain.usecases.scanproduct.ScanProductUseCaseImpl
import com.example.task.presentation.utils.ResourcesResolver
import com.example.task.presentation.utils.ResourcesResolverImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCasesModule {


    @Singleton
    @Binds
    abstract fun provideExpiredProductsUseCase(
        expiredProductsUseCaseImpl: ExpiredProductsUseCaseImpl
    ): ExpiredProductsUseCase

    @Singleton
    @Binds
    abstract fun provideFreshProductsUseCase(
        freshProductsUseCaseImpl: FreshProductsUseCaseImpl
    ): FreshProductsUseCase

    @Singleton
    @Binds
    abstract fun provideScanProductUseCase(
        scanProductUseCaseImpl: ScanProductUseCaseImpl
    ): ScanProductUseCase

    @Singleton
    @Binds
    abstract fun provideHourlyExpiredDateReportUseCase(
        hourlyExpiredDateReportUseCaseImpl: HourlyExpiredDateReportUseCaseImpl
    ): HourlyExpiredDateReportUseCase

    @Singleton
    @Binds
    abstract fun provideResourcesResolver(
        resourcesResolverImpl: ResourcesResolverImpl
    ): ResourcesResolver


}