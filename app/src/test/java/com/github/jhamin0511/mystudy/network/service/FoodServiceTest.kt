package com.github.jhamin0511.mystudy.network.service

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@Suppress("BlockingMethodInNonBlockingContext")
@OptIn(ExperimentalCoroutinesApi::class)
class FoodServiceTest : ServiceTest() {
    private lateinit var service: FoodService

    override fun setUp() {
        super.setUp()

        service = retrofit.create(FoodService::class.java)
    }

    @Test
    fun getFoods_success_assertThat() = runTest {
        // Given
        mockWebServer.enqueue(success("food/get_foods_response"))
        // When
        val response = service.getFoods()
        // Then
        val takeRequest = mockWebServer.takeRequest()
        assertThat(takeRequest.method).matches(GET)
        assertThat(takeRequest.path).isEqualTo("/foods")

        ServiceResponseChecker.checkData(response)
    }
}
