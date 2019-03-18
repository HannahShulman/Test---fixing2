package com.cheetah.test.testing.koin.modules

import com.cheetah.test.testing.repository.CustomerCartDataSource
import com.cheetah.test.testing.repository.CustomerCartRepository
import com.cheetah.test.testing.repository.ICustomerCartDataSource
import org.koin.dsl.module.module


/**
 * This module is responsible for initiating the objects required for the repository level
 */

val customerCartRepositoryModule = module {

    single <ICustomerCartDataSource>{ CustomerCartDataSource(get()) }
    single { CustomerCartRepository(get(), get(), get()) }

}




