package com.example.task.presentation.ui.expiredproducts.mapper

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.task.domain.entity.Product
import com.example.task.presentation.ui.expiredproducts.ExpiredProductViewState
import com.example.task.presentation.utils.convertLongToStrDate
import javax.inject.Inject

class ExpiredProductViewStateMapperImpl @Inject constructor() :
    ExpiredProductViewStateMapper {

    override fun mapProductsToViewState(products: List<Product>): List<ExpiredProductViewState> {
        return products.map { mapProductToViewState(it) }
    }

    override fun mapProductToViewState(product: Product): ExpiredProductViewState {
        return with(product) {
            ExpiredProductViewState(
                code = code,
                name = name,
                type = type,
                expiredDate = applySpanToExpiredDate(expiredDate.convertLongToStrDate()),
                isExpired = product.isExpired,
                isWarningNotificationScheduled = product.isWarningNotificationScheduled
            )
        }

    }

    private fun applySpanToExpiredDate(expiredDate: String): SpannableString {
        val spannable = SpannableString(expiredDate)

        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            0,
            expiredDate.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }

}
