package com.example.task.presentation.ui.expiredproducts

import android.text.SpannableString

data class ExpiredProductViewState(
    val id: Long = 0,
    val code: String,
    val name: String,
    val type: String,
    val expiredDate: SpannableString,
    val isExpired: Boolean = false,
    val isWarningNotificationScheduled: Boolean = false
)
