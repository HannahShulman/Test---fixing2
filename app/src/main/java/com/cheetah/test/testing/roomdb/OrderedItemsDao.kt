package com.cheetah.test.testing.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cheetah.test.testing.vo.OrderItemsInformation

/**
 * This class is responsible for local storage queries made for orderedItems DB
 */
@Dao
abstract class OrderedItemsDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveOrderedInformation(vararg orderedItems : OrderItemsInformation)
//    abstract fun saveOrderedInformation(vararg orderedItems : OrderItemsInformation)

    @Query("SELECT * FROM orderitemsinformation")
    abstract fun loadOrderedItemsInfo(): LiveData<List<OrderItemsInformation>>
}