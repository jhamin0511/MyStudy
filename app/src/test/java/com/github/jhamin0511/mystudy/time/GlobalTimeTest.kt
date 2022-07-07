package com.github.jhamin0511.mystudy.time

import com.google.common.truth.Truth.assertThat
import java.util.Date
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class GlobalTimeTest {
    @DisplayName("Number 데이터를 날짜 문자열로 변환")
    @Test
    fun covertDate_number_assertThat() {
        // Given
        val expected = "2022-07-05"
        val currentTime = 1656999706390
        // When
        val actual = GlobalTime.convertDate(currentTime)
        // Then
        assertThat(actual).isEqualTo(expected)
        assertEquals(expected, actual)
    }

    @DisplayName("날짜 문자열을 Date()로 변환")
    @Test
    fun parseDate_dateString_assertThat() {
        // Given
        val expected = Date(1656946800000)
        val currentDate = "2022-07-05"
        // When
        val actual = GlobalTime.parseDate(currentDate)
        // Then
        assertThat(actual).isEqualTo(expected)
    }
}
