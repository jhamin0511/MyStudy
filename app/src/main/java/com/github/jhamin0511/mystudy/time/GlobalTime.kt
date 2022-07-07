package com.github.jhamin0511.mystudy.time

import java.text.SimpleDateFormat
import java.util.Date

object GlobalTime {
    private const val PATTERN_DATE = "yyyy-MM-dd"
    private const val PATTERN_TIME = "HH:mm:ss"
    private const val PATTERN_UTC = "+hh:mm"
    private const val PATTERN_ISO_8601 = "${PATTERN_DATE}'T'${PATTERN_TIME}${PATTERN_UTC}"

    private val formatDate = SimpleDateFormat(PATTERN_DATE)
    private val formatTime = SimpleDateFormat(PATTERN_TIME)
    private val formatDateTime = SimpleDateFormat(PATTERN_ISO_8601)

    fun convertDate(value: Number): String {
        return formatDate.format(value)
    }

    fun parseDate(value: String): Date {
        return formatDate.parse(value) ?: Date()
    }

    fun convertTime(value: Number): String {
        return formatTime.format(value)
    }

    fun parseTime(value: String): Date {
        return formatTime.parse(value) ?: Date()
    }

    fun convertDateTime(value: Number): String {
        return formatDateTime.format(value)
    }
}
