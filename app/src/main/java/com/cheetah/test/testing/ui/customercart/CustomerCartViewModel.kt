package com.cheetah.test.testing.ui.customercart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cheetah.test.testing.repository.CustomerCartRepository
import com.cheetah.test.testing.vo.CustomerCart
import com.cheetah.test.testing.vo.Resource


/**
 * This class is responsible to bind the UI  and the data,
 * notifies the UI with data received through the repository
 * whilst avoiding communication of UI and data sources.
 * Allowing the UI element stay as a listener only.
 */
class CustomerCartViewModel(private val customerCartRepository: CustomerCartRepository) : ViewModel() {

    fun getCustomerCart( searchString:String ? = ""): LiveData<Resource<CustomerCart>> {
        return customerCartRepository.getCustomerCart()
    }

}
