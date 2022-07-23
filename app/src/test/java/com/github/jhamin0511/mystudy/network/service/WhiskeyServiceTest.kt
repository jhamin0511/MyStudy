package com.github.jhamin0511.mystudy.network.service

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@Suppress("BlockingMethodInNonBlockingContext")
@OptIn(ExperimentalCoroutinesApi::class)
class WhiskeyServiceTest : ServiceTest() {
    private lateinit var service: WhiskeyService

    override fun setUp() {
        super.setUp()

        service = retrofit.create(WhiskeyService::class.java)
    }

    @Test
    fun getWhiskeys_success_assertThat() = runTest {
        // Given
        mockWebServer.enqueue(success("whiskey/get_whiskeys_response"))
        // When
        val response = service.getWhiskeys()
        // Then
        val request = mockWebServer.takeRequest()
        assertThat(request.method).matches("GET")
        assertThat(request.path).isEqualTo("/whiskeys")

        ServiceResponseChecker.checkData(response)
    }
}
