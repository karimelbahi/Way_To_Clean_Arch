package com.example.task.presentation.ui.scanproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.R
import com.example.task.domain.entity.Product
import com.example.task.domain.usecases.scanproduct.ScanProductUseCase
import com.example.task.presentation.utils.ResourcesResolver
import com.example.task.presentation.utils.convertLongToStrDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ScanProductViewModel @Inject constructor(
    private val resourcesResolver: ResourcesResolver,
    private val scanProductUseCase: ScanProductUseCase
) : ViewModel() {


    val productCode: MutableLiveData<String> = MutableLiveData()
    val productName: MutableLiveData<String> = MutableLiveData()
    val productType: MutableLiveData<String> = MutableLiveData()
    val productDate: MutableLiveData<String> = MutableLiveData()

    private val _insertEvent: MutableLiveData<String> = MutableLiveData()
    val insertEvent = _insertEvent as LiveData<String>

    fun insertProduct(product: Product) {

        if (productDateValidation(product))
            viewModelScope.launch {
                val response = scanProductUseCase.insertProduct(product)
                if (response > 0) {
                    withContext(Dispatchers.Main) {
                        _insertEvent.postValue(resourcesResolver.getString(R.string.product_added_successful))
                    }
                }
            }
    }

    fun productDateValidation(product: Product): Boolean {
        var validate = true

        if (product.code.isBlank()) {
            validate = false
            productCode.value = resourcesResolver.getString(R.string.enter_valid_product_code)
        } else
            productCode.value = resourcesResolver.getString(R.string.empty)

        if (product.name.isBlank()) {
            validate = false
            productName.value = resourcesResolver.getString(R.string.enter_valid_product_name)
        } else
            productName.value = resourcesResolver.getString(R.string.empty)

        when {
            product.type.isBlank() -> {
                validate = false
                productType.value = resourcesResolver.getString(R.string.select_product_type)
            }

            product.expiredDate.convertLongToStrDate() < System.currentTimeMillis()
                .convertLongToStrDate() -> {
                validate = false
                productDate.value = resourcesResolver.getString(R.string.select_correct_expire_date)
            }
        }
        return validate
    }

}