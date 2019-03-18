package com.cheetah.test.testing.koin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cheetah.test.testing.repository.CustomerCartRepository
import com.cheetah.test.testing.ui.customercart.CustomerCartViewModel


/**
 * This class is responsible for generating a
 * inherited ViewModelProvider.Factory, to enable injection to ViewModel, in constructor
 */

class CustomerCartViewModelFactory(private val repository: CustomerCartRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CustomerCartViewModel(repository) as T
    }
}