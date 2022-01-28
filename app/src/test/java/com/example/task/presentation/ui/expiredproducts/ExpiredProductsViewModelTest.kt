package com.example.task.presentation.ui.expiredproducts

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import com.example.task.data.ProductRepoTest
import com.example.task.presentation.ui.freshproducts.FreshProductsViewModel
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

    @Before
    fun setUp() {
        val application = Mockito.mock(Application::class.java)
        scanProductViewModelTest = ExpiredProductsViewModel(
            application,
            FakeExpiredProductViewStateMapper(),
            FakeExpiredProductsUseCaseTest()
        )
    }

    @Test
    fun test_getExpiredProducts() {
        Assert.assertTrue(true)

    }
}