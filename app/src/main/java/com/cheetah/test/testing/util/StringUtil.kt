package com.cheetah.test.testing.util


/**
 * This class is responsible the methods used to display objects as text, used for DataBinding
 */
object StringUtil {

    fun getQuantityString(quantity: Int): String  = "Qty: $quantity"

    fun convertIntoToPrice(price:Int):String{
        return "$${price/100.00}"
    }

    fun getTotalCostString(value:Int):String{
        return "Total:  $${value/100.00}"
    }

    fun patternForPackageType(packageType :String):String{
        return "/$packageType"
    }


}