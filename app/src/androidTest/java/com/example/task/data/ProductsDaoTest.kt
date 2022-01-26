package com.example.task.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.task.data.local.daos.ProductsDao
import com.example.task.data.local.database.ProductsDatabase
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.matcher.ViewMatchers.assertThat

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.matcher.ViewMatchers
import com.example.task.data.local.database.model.ProductDB
import com.example.task.utilities.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo


//@ExperimentalCoroutinesApi
//@RunWith(AndroidJUnit4::class)
//@SmallTest
class ProductsDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var productsDatabase: ProductsDatabase
    private lateinit var dao: ProductsDao

    @Before
    fun createDb() = runBlocking {
        val context =
            InstrumentationRegistry.getInstrumentation().targetContext // = ApplicationProvider.getApplicationContext()
        productsDatabase = Room.inMemoryDatabaseBuilder(
            context,
            ProductsDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = productsDatabase.productsDao()
    }

    @After
    fun teardown() {
        productsDatabase.close()
    }

    @Test
    fun test_insertBaseProduct() = runBlocking {
        dao.insertProduct(baseTestProduct)
        assertThat(
            dao.getFreshProducts().first().size,
            equalTo(1)
        )
    }

    @Test
    fun test_insertProduct() = runBlocking {
        dao.insertProduct(secondTestProduct)
        dao.insertProduct(thirdTestProduct)

        assertThat(
            dao.getFreshProducts().first().size,
            equalTo(2)
        )
    }

    @Test
    fun test_getFreshProducts() = runBlocking {

        dao.insertProduct(firstTestProduct.also { it.isExpired = true })
        dao.insertProduct(secondTestProduct)
        dao.insertProduct(thirdTestProduct)

        assertThat(
            dao.getFreshProducts().first().size,
            equalTo(2)
        )
    }

    @Test
    fun test_getFreshProductsAsc() = runBlocking {
        dao.insertProduct(secondTestProduct)
        dao.insertProduct(firstTestProduct)

        assertThat(
            dao.getFreshProducts().first()[0],
            equalTo(firstTestProduct)
        )

        assertThat(
            dao.getFreshProducts().first()[1],
            equalTo(secondTestProduct)
        )
    }

    @Test
    fun test_updateProductsExpiredDateStatus() = runBlocking {

        // insert product
        dao.insertProduct(firstTestProduct)
        assertThat(
            dao.getFreshProducts().first().size,
            equalTo(1)
        )

        // update product
        dao.updateProductsExpiredDateStatus(firstTestProduct.id)
        assertThat(
            dao.getFreshProducts().first().size,
            equalTo(0)
        )
    }

    @Test
    fun test_updateScheduledNotifications_With_No_Notification_Scheduled() = runBlocking {

        // insert product
        dao.insertProduct(firstTestProduct)
        dao.insertProduct(secondTestProduct)

        assertThat(
            dao.updateScheduledNotifications(true),
            equalTo(2)
        )
    }

    @Test
    fun test_updateScheduledNotifications_With_Exist_Notification_Scheduled() = runBlocking {

        // insert product
        dao.insertProduct(firstTestProduct)
        dao.insertProduct(secondTestProduct)
        dao.insertProduct(thirdTestProduct.also { it.isWarningNotificationScheduled = true })

        assertThat(
            dao.updateScheduledNotifications(true),
            equalTo(2)
        )
    }
}