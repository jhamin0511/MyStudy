package com.github.jhamin0511.mystudy.network.service

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@Suppress("BlockingMethodInNonBlockingContext")
@OptIn(ExperimentalCoroutinesApi::class)
class AnimalServiceTest : ServiceTest() {
    private lateinit var service: AnimalService

    override fun setUp() {
        super.setUp()

        service = retrofit.create(AnimalService::class.java)
    }

    @Test
    fun getAnimals_success_assertThat() = runTest {
        // Given
        mockWebServer.enqueue(success("animal/get_animals_response"))
        val page = 1
        val perPage = 30
        val search = "Monkey"
        // When
        val response = service.getAnimals(page, perPage, search)
        // Then
        val takeRequest = mockWebServer.takeRequest()
        assertThat(takeRequest.method).matches(GET)
        val path = "/animals?page=1&per_page=30&search=Monkey"
        assertThat(takeRequest.path).isEqualTo(path)

        ServiceResponseChecker.checkData(response)
    }
}
