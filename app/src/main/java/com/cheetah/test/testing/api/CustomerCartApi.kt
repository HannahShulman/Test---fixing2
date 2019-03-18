package com.cheetah.test.testing.api

import androidx.lifecycle.LiveData
import com.cheetah.test.testing.vo.CustomerCart
import retrofit2.http.GET


/**
 * This class is responsible for holding endpoints related to customerCartRequest
 */

interface  CustomerCartApi{

    @GET("59c791ed1100005300c39b93")
    fun getCustomerCart(): LiveData<ApiResponse<CustomerCart>>
}