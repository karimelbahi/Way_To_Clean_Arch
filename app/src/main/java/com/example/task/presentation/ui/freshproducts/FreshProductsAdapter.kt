package com.example.task.presentation.ui.freshproducts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.app.MyApplication
import com.example.task.databinding.ProductListItemBinding
import com.example.task.domain.entity.Product
import com.example.task.presentation.utils.convertLongToStrDate
import com.example.task.presentation.utils.currentTime
import com.example.task.presentation.utils.diffDaysBetweenTwoTimes
import javax.inject.Inject

class FreshProductsAdapter @Inject constructor() :
    ListAdapter<Product, FreshProductsAdapter.ViewHolder>(CountryListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.apply {
                with(product) {
                    val leftDays = diffDaysBetweenTwoTimes(product.expiredDate, currentTime())
                    productsNameTv.text = name
                    productsCodeTv.text = code
                    productTypeTv.text = type
                    expireDateTv.text = expiredDate.convertLongToStrDate()
                    remainingDaysTv.text =
                        MyApplication.applicationContext()
                            .getString(R.string.left_days_num, leftDays)
                }
            }
        }
    }


    class CountryListDiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldProduct: Product, newProduct: Product): Boolean {
            return oldProduct.id == newProduct.id
        }

        override fun areContentsTheSame(oldProduct: Product, newProduct: Product): Boolean {
            return oldProduct == newProduct
        }

    }

}