package com.example.task.data.mapper

import com.example.task.data.local.database.model.ProductDB
import com.example.task.domain.entity.Product

interface ProductDBMapper {

    fun mapDomainProductToDb(product: Product): ProductDB
    fun mapDBProductToDomain(productDB: ProductDB): Product

    fun mapDomainProductsToDb(product: List<Product>): List<ProductDB>
    suspend fun mapDBProductsToDomain(productDB: List<ProductDB>): List<Product>

}