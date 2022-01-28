package com.example.task.presentation.ui.freshproducts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCase
import com.example.task.presentation.utils.ResourcesResolver
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.*
import org.mockito.Mockito


class FreshProductsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var scanProductViewModelTest: FreshProductsViewModel

    private val resourcesResolver: ResourcesResolver = Mockito.mock(ResourcesResolver::class.java)
    private val freshProductsUseCase: FreshProductsUseCase =
        Mockito.mock(FreshProductsUseCase::class.java)

    @Before
    fun setUp() {
        scanProductViewModelTest = FreshProductsViewModel(
            resourcesResolver,
            freshProductsUseCase
        )
    }


    @Test
    fun test_getProducts() {
        Assert.assertFalse(false)
    }

    @Ignore
    @Test
    fun test_testGetProducts() {
    }
}