package com.example.task.utilities

import com.example.task.data.local.database.model.ProductDB


/**
 * [ProductDB] objects used for tests.
 */
val testProducts = arrayListOf(
    ProductDB(
        0L,
        "Base code",
        "Name code",
        "Type",
        System.currentTimeMillis(),
        isExpired = false,
        isWarningNotificationScheduled = false
    ),
    ProductDB(
        1L,
        "Apple code",
        "Apple code",
        "Food",
        System.currentTimeMillis() + 10,
        isExpired = false,
        isWarningNotificationScheduled = false
    ),
    ProductDB(
        2L,
        "Pepsi code",
        "Pepsi",
        "Drink",
        System.currentTimeMillis() + 20,
        isExpired = false,
        isWarningNotificationScheduled = false
    ),
    ProductDB(
        3L,
        "Anti Piotek Code",
        "Anti Piotek",
        "Drug",
        System.currentTimeMillis() + 20,
        isExpired = false,
        isWarningNotificationScheduled = false
    )
)
val baseTestProduct = testProducts[0]
val firstTestProduct = testProducts[1]
val secondTestProduct = testProducts[2]
val thirdTestProduct = testProducts[3]