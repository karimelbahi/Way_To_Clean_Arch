package com.example.task.presentation.ui.expiredproducts

import com.example.task.domain.entity.Product
import com.example.task.presentation.ui.expiredproducts.ExpiredProductViewState
import com.example.task.presentation.ui.expiredproducts.mapper.ExpiredProductViewStateMapper

class FakeExpiredProductViewStateMapper : ExpiredProductViewStateMapper {
    override fun mapProductsToViewState(products: List<Product>): List<ExpiredProductViewState> {
        TODO("Not yet implemented")
    }

    override fun mapProductToViewState(product: Product): ExpiredProductViewState {
        TODO("Not yet implemented")
    }
}