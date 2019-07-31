
package com.zues.baseutils.Utils

/* ---  Created by akhtarz on 7/31/2019. ---*/
object StringUtils {

    fun getDoubleFromString(number: String?): Double {
        var num: String? = number ?: return 0.0
        num = num?.replace("[A-Za-z $,;:]".toRegex(), "")

        if (num.isNullOrEmpty()) return 0.0
        //        Log.e("Utils", "Number: " + number);
        try {
            return java.lang.Double.parseDouble(number)
        } catch (e: Exception) {
            return 0.0
        }

    }
}