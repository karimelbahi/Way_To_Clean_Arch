package com.example.task.domain.usecases.scanproduct

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.MainCoroutineRule
import com.example.task.data.ProductRepoTest
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ScanProductUseCaseImplTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var scanProductUseCaseImpl: ScanProductUseCaseImpl


    @Before
    fun setUp() {
        scanProductUseCaseImpl = ScanProductUseCaseImpl(ProductRepoTest())
    }

    @After
    fun tearDown() {
    }

    @Test
    fun insertProduct() {
    }
}