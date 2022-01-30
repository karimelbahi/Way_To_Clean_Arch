package com.example.task.presentation.ui.freshproducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.R
import com.example.task.domain.entity.Product
import com.example.task.domain.usecases.freshproducs.FreshProductsUseCase
import com.example.task.presentation.utils.Constants.PRODUCTS_LIST_MINIMUM_COUNT
import com.example.task.presentation.utils.Resource
import com.example.task.presentation.utils.ResourcesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class FreshProductsViewModel @Inject constructor(
    private val resourcesResolver: ResourcesResolver,
    private val freshProductsUseCase: FreshProductsUseCase
) : ViewModel() {

    private val _products: MutableLiveData<Resource<List<Product>>> = MutableLiveData()
    val products = _products as LiveData<Resource<List<Product>>>

    fun getFreshProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            freshProductsUseCase.updateAllProductsExpiredDateStatus()
            freshProductsUseCase.getProducts()
                .onStart {
                }.catch { error ->
                    withContext(Dispatchers.Main) {
                        _products.value = Resource(
                            Resource.Status.ERROR,
                            null,
                            error.message
                        )
                    }
                }.collect { result ->
                    withContext(Dispatchers.Main) {

                        if (result.size < PRODUCTS_LIST_MINIMUM_COUNT)
                            _products.value = Resource(
                                Resource.Status.SUCCESS,
                                result,
                                resourcesResolver.getString(
                                    R.string.num_of_products_is_less_than_allowed_num,
                                    PRODUCTS_LIST_MINIMUM_COUNT
                                )
                            )
                        else
                            _products.value = Resource(
                                Resource.Status.SUCCESS,
                                result,
                                resourcesResolver.getString(R.string.products_fetched_successfully)
                            )
                    }
                }
        }
    }
}