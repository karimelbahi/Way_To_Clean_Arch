package com.example.task.presentation.ui.freshproducts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.*


class FreshProductsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var scanProductViewModelTest: FreshProductsViewModel

    @Before
    fun setUp() {
        /**
         * https://stackoverflow.com/a/62312473
         * we can use val resource = Mockito.mock(ResourcesResolver::class.java) to inject interface (instead of FakeResourcesResolverTest() )
         * */
        scanProductViewModelTest = FreshProductsViewModel(
            FakeResourcesResolverTest(),
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