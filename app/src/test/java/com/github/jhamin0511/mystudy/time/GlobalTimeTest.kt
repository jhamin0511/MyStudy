package com.github.jhamin0511.mystudy.time

import com.google.common.truth.Truth.assertThat
import java.util.Date
import kotlin.test.assertEquals
import org.junit.Test

internal class GlobalTimeTest {
    @Test
    fun covertDate_withNumber_assertThat() {
        // Given
        val expected = "2022-07-05"
        val currentTime = 1656999706390
        // When
        val actual = GlobalTime.convertDate(currentTime)
        // Then
        assertThat(actual).isEqualTo(expected)
        assertEquals(expected, actual)
    }

    @Test
    fun parseDate_withDateString_assertThat() {
        // Given
        val expected = Date(1656946800000)
        val currentDate = "2022-07-05"
        // When
        val actual = GlobalTime.parseDate(currentDate)
        // Then
        assertThat(actual).isEqualTo(expected)
    }
}
