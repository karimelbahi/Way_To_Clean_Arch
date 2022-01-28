package com.example.task.presentation.ui.expiredproducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.R
import com.example.task.domain.usecases.expiredprducts.ExpiredProductsUseCase
import com.example.task.presentation.ui.expiredproducts.mapper.ExpiredProductViewStateMapper
import com.example.task.presentation.utils.Resource
import com.example.task.presentation.utils.ResourcesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ExpiredProductsViewModel @Inject constructor(
    private val resourcesResolver: ResourcesResolver,
    private val expiredProductViewState: ExpiredProductViewStateMapper,
    private val expiredProductsUseCase: ExpiredProductsUseCase
) : ViewModel() {

    private val _expiredProducts: MutableLiveData<Resource<List<ExpiredProductViewState>>> =
        MutableLiveData()
    val expiredProducts = _expiredProducts as LiveData<Resource<List<ExpiredProductViewState>>>

    fun getExpiredProducts() {
        viewModelScope.launch {
            expiredProductsUseCase.getExpiredProducts()
                .onStart {
                    withContext(Dispatchers.Main) {
                        _expiredProducts.value = Resource(
                            Resource.Status.LOADING,
                            null,
                            resourcesResolver.getString(R.string.loading)
                        )
                    }
                }.catch { error ->
                    withContext(Dispatchers.Main) {
                        _expiredProducts.value = Resource(
                            Resource.Status.ERROR,
                            null,
                            resourcesResolver.getString(R.string.failed_to_load_data)
                        )
                    }
                }.collect { result ->
                    withContext(Dispatchers.Main) {
                        _expiredProducts.value = Resource(
                            Resource.Status.SUCCESS,
                            expiredProductViewState.mapProductsToViewState(result),
                            resourcesResolver.getString(R.string.products_fetched_successfully)
                        )
                    }
                }
        }
    }

}