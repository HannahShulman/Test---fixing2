package com.cheetah.test.testing.roomdb

import androidx.room.TypeConverter
import com.cheetah.test.testing.vo.OrderItemsInformation
import com.cheetah.test.testing.vo.Product
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject
import timber.log.Timber
import com.google.gson.reflect.TypeToken
import java.util.*


/**
 * This class is responsible for converting objects to primitives,
 * so that db can hold and provide back(convert back)as object
 */
object DatabaseTypeConverters {

    @TypeConverter
    @JvmStatic
    fun orderItemListToString(list: List<OrderItemsInformation>): String? {
        return Gson().toJson(list).toString()
    }

    @TypeConverter
    @JvmStatic
    fun stringToOrderItemList(list: String): List<OrderItemsInformation>? {
        val listType = object : TypeToken<List<OrderItemsInformation>>() {
        }.type
        return Gson().fromJson(list, listType)
    }
}
