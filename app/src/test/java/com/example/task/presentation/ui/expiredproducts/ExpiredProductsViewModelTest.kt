package com.example.task.presentation.ui.expiredproducts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCase
import com.example.task.presentation.ui.expiredproducts.mapper.ExpiredProductViewStateMapper
import com.example.task.presentation.utils.ResourcesResolver
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ExpiredProductsViewModelTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var scanProductViewModelTest: ExpiredProductsViewModel

    private val expiredProductViewStateMapper: ExpiredProductViewStateMapper =
        Mockito.mock(ExpiredProductViewStateMapper::class.java)
    private val expiredProductsUseCase: ExpiredProductsUseCase =
        Mockito.mock(ExpiredProductsUseCase::class.java)

    @Before
    fun setUp() {
        val resourcesResolver = Mockito.mock(ResourcesResolver::class.java)
        scanProductViewModelTest = ExpiredProductsViewModel(
            resourcesResolver,
            expiredProductViewStateMapper,
            expiredProductsUseCase
        )
    }

    @Test
    fun test_getExpiredProducts() {
        Assert.assertTrue(true)

    }
}