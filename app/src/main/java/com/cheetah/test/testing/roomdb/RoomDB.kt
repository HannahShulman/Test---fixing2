package com.cheetah.test.testing.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheetah.test.testing.vo.CustomerCart

@Database(entities = [CustomerCart::class] ,version = RoomDB.VERSION, exportSchema = false)
abstract class RoomDB: RoomDatabase() {

    abstract fun customerCartDao(): CustomerCartDao

    companion object {
        const val VERSION = 2
    }
}