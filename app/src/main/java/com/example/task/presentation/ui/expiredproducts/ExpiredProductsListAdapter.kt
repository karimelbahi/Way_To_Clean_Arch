package com.example.task.presentation.ui.freshproducts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.ExpiredProductListItemBinding
import com.example.task.presentation.ui.expiredproducts.ExpiredProductViewState
import javax.inject.Inject

class ExpiredProductsAdapter @Inject constructor() :
    ListAdapter<ExpiredProductViewState, ExpiredProductsAdapter.ViewHolder>(CountryListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ExpiredProductListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ExpiredProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ExpiredProductViewState) {
            binding.apply {
                with(product){
                productsNameTv.text = name
                productsCodeTv.text = code
                productTypeTv.text = type
                expireDateTv.text = expiredDate
                }
            }
        }
    }


    class CountryListDiffCallback : DiffUtil.ItemCallback<ExpiredProductViewState>() {

        override fun areItemsTheSame(oldProduct: ExpiredProductViewState, newProduct: ExpiredProductViewState): Boolean {
            return oldProduct.id == newProduct.id
        }

        override fun areContentsTheSame(oldProduct: ExpiredProductViewState, newProduct: ExpiredProductViewState): Boolean {
            return oldProduct == newProduct
        }

    }

}