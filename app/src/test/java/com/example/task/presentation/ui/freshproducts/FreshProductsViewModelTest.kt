package com.example.task.presentation.ui.freshproducts

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import com.example.task.data.ProductRepoTest
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCase
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

    @Before
    fun setUp() {
        val application = Mockito.mock(Application::class.java)
        scanProductViewModelTest = FreshProductsViewModel(
            application,
            FakeFreshProductsUseCaseTest()
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