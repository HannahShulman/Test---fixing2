package com.cheetah.test.testing.ui.customercart

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.cheetah.test.testing.repository.CustomerCartRepository
import com.cheetah.test.testing.vo.CustomerCart
import com.cheetah.test.testing.vo.OrderItemsInformation
import com.cheetah.test.testing.vo.Resource


/**
 * This class is responsible to bind the UI  and the data,
 * notifies the UI with data received through the repository
 * whilst avoiding communication of UI and data sources.
 * Allowing the UI element stay as a listener only.
 */
class CustomerCartViewModel(private val customerCartRepository: CustomerCartRepository) : ViewModel() {

    /**
     * @param searchString The string to filter the query when searching for items
     */
    fun getCustomerCart(searchString:String ? = ""): LiveData<Resource<CustomerCart>> {

        /**
         * Trying out Transformation
         */
        Transformations.map(customerCartRepository.getCustomerCart()) {
             it.data?.orderItemsInformation?.filter {
                 it.product?.name?.toLowerCase()?.contains(searchString as CharSequence)?:true
             }
         }

        return customerCartRepository.getCustomerCart()
        }

    fun getOrderedItems():LiveData<List<OrderItemsInformation>>{
        return customerCartRepository.getOrderedItemsInfo()
    }


}
