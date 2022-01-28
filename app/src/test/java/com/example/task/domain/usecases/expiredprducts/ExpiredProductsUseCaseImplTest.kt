package com.example.task.domain.usecases.expiredprducts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import com.example.task.domain.repo.ProductsRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ExpiredProductsUseCaseImplTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var expiredProductsUseCaseImpl: ExpiredProductsUseCaseImpl
    private val productsRepo = Mockito.mock(ProductsRepo::class.java)


    @Before
    fun setUp() {
        expiredProductsUseCaseImpl = ExpiredProductsUseCaseImpl(productsRepo)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getExpiredProducts() {
    }
}