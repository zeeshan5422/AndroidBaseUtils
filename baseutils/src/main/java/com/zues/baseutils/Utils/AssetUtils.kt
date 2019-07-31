package com.zues.baseutils.Utils

import android.content.Context

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by akhtarz on 7/30/2019.
 */

object AssetUtils {

    fun readFromAssets(context: Context, filename: String): String? {
        try {
            val reader = BufferedReader(InputStreamReader(context.assets.open(filename)))

            val sb = StringBuilder()
            var mLine: String? = reader.readLine()
            while (mLine != null) {
                sb.append(mLine)
                mLine = reader.readLine()
            }
            reader.close()
            return sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
