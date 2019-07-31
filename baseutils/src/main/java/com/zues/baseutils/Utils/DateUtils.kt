package com.zues.baseutils.Utils

import java.util.Calendar
import java.util.Date

/**
 * Created by akhtarz on 7/30/2019.
 */

object DateUtils {

    val currentDateToDisplay: String
        get() = getDateToDisplayFromMilliseconds(Calendar.getInstance().timeInMillis)

    fun getDateToDisplay(date: Date): String {
        return getDateToDisplayFromMilliseconds(date.time)
    }

    fun getDateToDisplayFromMilliseconds(milliseconds: Long?): String {
        if (milliseconds == null || milliseconds == 0L) {
            return ""
        }
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliseconds
        return "" + String.format(
            "%02d",
            calendar.get(Calendar.DAY_OF_MONTH)
        ) + " " + getMonthName(calendar.time) + " " + calendar.get(Calendar.YEAR)
    }

    private fun getMonthName(date: Date): String {
        return android.text.format.DateFormat.format("MMM", date) as String
    }

    fun daysToMillis(days: Int): Long {
        return (days * 1000 * 60 * 60 * 24).toLong()
    }


    fun isToday(lastDeletionTimestamp: Long): Boolean {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = lastDeletionTimestamp

        val today = Calendar.getInstance()

        return if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == today.get(
                Calendar.MONTH
            ) && calendar.get(
                Calendar.DAY_OF_MONTH
            ) == today.get(Calendar.DAY_OF_MONTH)
        ) {
            true
        } else false

    }

    fun backToStartOfDay(date: Long): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = date
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.timeInMillis
    }

    fun advanceToEndOfDay(date: Long): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = date
        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 59)
        cal.set(Calendar.SECOND, 59)
        cal.set(Calendar.MILLISECOND, 999)
        return cal.timeInMillis
    }
}
