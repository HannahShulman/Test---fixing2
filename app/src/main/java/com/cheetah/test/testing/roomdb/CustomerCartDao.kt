package com.cheetah.test.testing.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cheetah.test.testing.vo.CustomerCart

/**
 * This class is responsible for local storage queries made for customerCart DB
 */
@Dao
abstract class CustomerCartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCart(vararg cart: CustomerCart)


    @Query("SELECT * FROM customercart")
    abstract fun loadCart(): LiveData<CustomerCart>

}
