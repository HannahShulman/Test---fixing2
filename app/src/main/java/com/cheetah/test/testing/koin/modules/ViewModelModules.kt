package com.cheetah.test.testing.koin.modules

import com.cheetah.test.testing.ui.customercart.CustomerCartViewModel
import com.cheetah.test.testing.koin.CustomerCartViewModelFactory
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * This module is responsible for init the objects regarding the CustomerCartViewModel
 */

val CustomerCartViewModelModules = module {
    viewModel { CustomerCartViewModel(get()) }
    single { CustomerCartViewModelFactory(get()) }
}