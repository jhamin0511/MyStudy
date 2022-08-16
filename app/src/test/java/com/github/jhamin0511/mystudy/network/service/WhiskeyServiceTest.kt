package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.network.request.WhiskeyRequest
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
        val takeRequest = mockWebServer.takeRequest()
        assertThat(takeRequest.method).matches(GET)
        assertThat(takeRequest.path).isEqualTo("/whiskeys")

        ServiceResponseChecker.checkData(response)
    }

    @Test
    fun putWhiskey_success_assertThat() = runTest {
        // Given
        val expectedBody = requestBody("whiskey/put_whiskey_request")
        mockWebServer.enqueue(success("whiskey/put_whiskey_response"))
        val request = WhiskeyRequest(1, 1, "name", "price", "description", "history")
        // When
        val response = service.putWhiskey(request)
        // Then
        val takeRequest = mockWebServer.takeRequest()
        assertThat(takeRequest.method).matches(PUT)
        assertThat(takeRequest.path).matches("/whiskey")

        ServiceResponseChecker.checkData(response)
        assertThat(requestBody(takeRequest)).isEqualTo(expectedBody)
    }
}
