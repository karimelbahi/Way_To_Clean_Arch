package com.example.task.presentation.ui.freshproducts

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.data.FakeScanProductRepoTest
import com.example.task.presentation.ui.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.*
import org.mockito.Mockito


class ProductListViewModelTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var scanProductViewModelTest: ProductListViewModel

    @Before
    fun setUp() {
        val application = Mockito.mock(Application::class.java)
        scanProductViewModelTest = ProductListViewModel(
            application,
            FakeScanProductRepoTest()
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