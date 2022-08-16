package com.github.jhamin0511.mystudy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LiveDataExtKtTest {
    @Test(expected = NullPointerException::class)
    fun get_nullBoolean_assertThat() {
        // Given
        val liveData = MutableLiveData<Boolean>()
        // When
        val actual = liveData.value()
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun get_defaultBoolean_assertThat() {
        // Given
        val liveData = MutableLiveData<Boolean>()
        // When
        val actual = liveData.value(true)
        // Then
        assertThat(actual).isTrue()
    }

    @Test
    fun get_falseBoolean_assertThat() {
        // Given
        val liveData = MutableLiveData(false)
        // When
        val actual = liveData.value()
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun get_trueBoolean_assertThat() {
        // Given
        val liveData = MutableLiveData(true)
        // When
        val actual = liveData.value()
        // Then
        assertThat(actual).isTrue()
    }
}
