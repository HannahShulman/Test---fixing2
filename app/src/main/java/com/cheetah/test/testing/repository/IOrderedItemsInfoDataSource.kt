package com.cheetah.test.testing.repository

import androidx.lifecycle.LiveData
import com.cheetah.test.testing.vo.OrderItemsInformation

/**
 * This class/interface is responsible for putting together all methods for getting info
 */
interface IOrderedItemsInfoDataSource {

    fun getOrderedItemsInfo(): LiveData<List<OrderItemsInformation>>
}