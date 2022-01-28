package com.example.task.data.mapper

import com.example.task.data.local.database.model.ProductDB
import com.example.task.domain.entity.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDBMapperImpl @Inject constructor() : ProductDBMapper {

    override fun mapDomainProductToDb(product: Product): ProductDB {
        return ProductDB(
            code = product.code,
            name = product.name,
            type = product.type,
            expiredDate = product.expiredDate
        )

    }

    override fun mapDBProductToDomain(productDB: ProductDB): Product {
        return Product(
            id = productDB.id,
            code = productDB.code,
            name = productDB.name,
            type = productDB.type,
            expiredDate = productDB.expiredDate
        )
    }

    override fun mapDomainProductsToDb(product: List<Product>): List<ProductDB> {
        return product.map {
            with(it) {
                ProductDB(
                    id,
                    code,
                    name,
                    type,
                    expiredDate)

            }
        }
    }

    override suspend fun mapDBProductsToDomain(productDB: List<ProductDB>): List<Product> {
        return productDB.map {
            with(it){
                Product(
                    id, code, name, type, expiredDate
                )
            }
        }
    }

}