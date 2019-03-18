package com.cheetah.test.testing.repository

import androidx.lifecycle.LiveData
import com.cheetah.test.testing.api.ApiResponse
import com.cheetah.test.testing.vo.CustomerCart


/**
 * This class/interface is responsible for putting together all methods for getting info
 */
interface ICustomerCartDataSource {

    fun getCustomerCart(): LiveData<ApiResponse<CustomerCart>>
}