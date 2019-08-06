package com.cheetah.test.testing.repository

import androidx.lifecycle.LiveData
import com.cheetah.test.testing.api.ApiResponse
import com.cheetah.test.testing.api.CustomerCartApi
import com.cheetah.test.testing.vo.CustomerCart
import com.cheetah.test.testing.vo.OrderItemsInformation

/**
 * This class is responsible for implementing methods set for enquiring information
 */

class OrderedItemsDataSource (private val orderedItemsRepository: CustomerCartRepository):IOrderedItemsInfoDataSource {


    override fun getOrderedItemsInfo(): LiveData<List<OrderItemsInformation>> {
       return  orderedItemsRepository.getOrderedItemsInfo()
    }
}