package com.cheetah.test.testing.repository

import androidx.lifecycle.LiveData
import com.cheetah.test.testing.api.ApiResponse
import com.cheetah.test.testing.api.CustomerCartApi
import com.cheetah.test.testing.vo.CustomerCart


/**
 * This class is responsible for implementing methods set for enquiring information
 */

class CustomerCartDataSource (private val customerCartApi: CustomerCartApi):ICustomerCartDataSource {

    override fun getCustomerCart(): LiveData<ApiResponse<CustomerCart>> {
        return customerCartApi.getCustomerCart()
    }
}