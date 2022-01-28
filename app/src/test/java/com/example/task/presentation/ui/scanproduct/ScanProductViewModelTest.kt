package com.example.task.presentation.ui.scanproduct

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.task.data.ProductRepoTest
import com.example.task.domain.entity.Product
import com.example.task.MainCoroutineRule
import com.example.task.domain.usecases.scanproduct.ScanProductUseCaseImplTest
import com.example.task.presentation.utils.ResourcesResolver
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class ScanProductViewModelTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private lateinit var scanProductViewModelTest: ScanProductViewModel
    val resourcesResolver: ResourcesResolver = Mockito.mock(ResourcesResolver::class.java)

    @Before
    fun setUp() {
        scanProductViewModelTest =
            ScanProductViewModel(resourcesResolver, FakeScanProductUseCaseTest())
    }


    @Test
    fun `empty product code returns false`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = "",
                name = "painkiller",
                type = "Drug",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `blank product code returns false`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = " ",
                name = "painkiller",
                type = "Drug",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `empty product name returns false`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = "code",
                name = "",
                type = "Drug",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `blank product name returns false`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = "code",
                name = " ",
                type = "Drug",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `empty product type returns false`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = "code",
                name = "name",
                type = "",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `blank product type returns false`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = "code",
                name = "name",
                type = " ",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `wrong expiry date of product returns false`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = "code",
                name = "name",
                type = "",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `valid product returns true`() {

        val result = scanProductViewModelTest.productDateValidation(
            Product(
                code = "code",
                name = "name",
                type = "Drug",
                expiredDate = System.currentTimeMillis() + 100
            )
        )
        Assert.assertTrue(result)
    }
}