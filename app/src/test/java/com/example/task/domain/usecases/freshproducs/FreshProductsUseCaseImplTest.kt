package com.example.task.domain.usecases.freshproducs

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import com.example.task.data.ProductRepoTest
import kotlinx.coroutines.ExperimentalCoroutinesApi

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FreshProductsUseCaseImplTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var freshProductsUseCaseImplTest: FreshProductsUseCaseImpl


    @Before
    fun setUp() {
        freshProductsUseCaseImplTest = FreshProductsUseCaseImpl(ProductRepoTest())
    }

    @After
    fun tearDown() {
    }

    @Test
    fun checkProductsExpiredDateStatus() {

    }

    @Test
    fun getProducts() {
    }

    @Test
    fun getFreshProductsSnapshot() {
    }

    @Test
    fun updateScheduledNotifications() {
    }
}