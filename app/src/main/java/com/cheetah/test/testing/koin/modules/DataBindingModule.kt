package com.cheetah.test.testing.koin.modules

import com.cheetah.test.testing.repository.*
import org.koin.dsl.module.module


/**
 * This module is responsible for initiating the objects required for the repository level
 */

val customerCartRepositoryModule = module {

    single <ICustomerCartDataSource>{ CustomerCartDataSource(get()) }
    single { CustomerCartRepository(get(), get(), get(), get()) }

}


val orderedItemsRepositoryModule = module {

    single <IOrderedItemsInfoDataSource>{ OrderedItemsDataSource(get()) }

}




