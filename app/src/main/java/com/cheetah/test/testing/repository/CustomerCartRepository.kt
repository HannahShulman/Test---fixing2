package com.cheetah.test.testing.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.cheetah.test.testing.AppExecutors
import com.cheetah.test.testing.api.ApiResponse
import com.cheetah.test.testing.remote.NetworkBoundResource
import com.cheetah.test.testing.roomdb.RoomDB
import com.cheetah.test.testing.vo.CustomerCart
import com.cheetah.test.testing.vo.OrderItemsInformation
import com.cheetah.test.testing.vo.Resource


/**
 * This class is responsible for all business logic needed for getting information from remote/local -
 */

class CustomerCartRepository(private val appExecutors: AppExecutors, private val roomDB: RoomDB,
                             private val customerCartRemoteDataSource: ICustomerCartDataSource,
                             private val orderedItemsRemoteDataSource :RoomDB) {



    fun getOrderedItemsInfo() : LiveData<List<OrderItemsInformation>>{
        val l = orderedItemsRemoteDataSource.orderedItemsDao().loadOrderedItemsInfo()
        Log.d("LOADING_DATA", l.value?.size.toString()?:" random msg 4 null")
        return l
    }


    fun getCustomerCart(): LiveData<Resource<CustomerCart>> {

        return object : NetworkBoundResource<CustomerCart, CustomerCart>(appExecutors) {
            override fun saveCallResult(item: CustomerCart) {
                roomDB.customerCartDao().insertCart(item)
                item.orderItemsInformation?.run{
                    for (i in this)
                        roomDB.orderedItemsDao().saveOrderedInformation(i)
                }
            }
            override fun shouldFetch(data: CustomerCart?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<CustomerCart> = roomDB.customerCartDao().loadCart()

            override fun createCall(): LiveData<ApiResponse<CustomerCart>> {
                return customerCartRemoteDataSource.getCustomerCart()
            }

        }.asLiveData()
    }
}