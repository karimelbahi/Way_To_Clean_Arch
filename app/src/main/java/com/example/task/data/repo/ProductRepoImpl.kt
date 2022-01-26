package com.example.task.data.repo

import com.example.task.data.local.daos.ProductsDao
import com.example.task.data.local.database.model.ProductDB
import com.example.task.data.mapper.ProductDBMapper
import com.example.task.domain.entity.Product
import com.example.task.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val productDBMapper: ProductDBMapper,
    private val productsDao: ProductsDao
) :
    ProductsRepo {

    override suspend fun checkProductsExpiredDateStatus() {
        productsDao.getFreshProducts().first().map { product ->
            if (product.expiredDate < System.currentTimeMillis())
                productsDao.updateProductsExpiredDateStatus(product.id)
        }
    }

    override suspend fun getProducts(): Flow<List<Product>> = productsDao.getFreshProducts().map {
        productDBMapper.mapDBProductsToDomain(it)
    }

    override suspend fun getFreshProductsSnapshot(): List<Product> =
        productsDao.getFreshProducts().first().map {
            productDBMapper.mapDBProductToDomain(it)
        }

    override suspend fun updateScheduledNotifications(): Int =
        productsDao.updateScheduledNotifications()

    override suspend fun getExpiredProducts() = productsDao.getExpiredProducts().map {
        productDBMapper.mapDBProductsToDomain(it)
    }

    override suspend fun insertProduct(product: Product) = productsDao.insertProduct(
        productDBMapper.mapDomainProductToDb(product)
    )


}