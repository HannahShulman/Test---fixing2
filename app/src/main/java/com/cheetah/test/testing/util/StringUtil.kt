package com.cheetah.test.testing.util

import java.text.DecimalFormat


/**
 * This class is responsible the methods used to display objects as text, used for DataBinding
 */
object StringUtil {

    fun getQuantityString(quantity: Int): String  = "Qty: $quantity"

    fun convertIntToString(value: Int): String  = "$value"

    fun convertIntoToPrice(price:Int):String{
        val decimPrice = price/100.00
        val formatter = DecimalFormat("###,###,##0.00")
        val formattedNumber = formatter.format(decimPrice)
        return "$$formattedNumber"
    }

    fun getTotalCostString(value:Int):String{
        val decimPrice = value/100.00
        val formatter = DecimalFormat("###,###,##0.00")
        val formattedNumber = formatter.format(decimPrice)
        return "Total:  $$formattedNumber"
    }

    fun patternForPackageType(packageType :String):String{
        return "/$packageType"
    }


}