package com.example.task.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Long=0,
    val code: String,
    val name: String,
    val type: String,
    val expiredDate: Long
) : Parcelable