package com.example.task.presentation.ui.expiredproducts.mapper

import com.example.task.domain.entity.Product
import com.example.task.presentation.ui.expiredproducts.ExpiredProductViewState

interface ExpiredProductViewStateMapper {

    fun mapProductsToViewState(products: List<Product>): List<ExpiredProductViewState>

    fun mapProductToViewState(product: Product): ExpiredProductViewState

}