package com.github.jhamin0511.mystudy.network.service

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@Suppress("BlockingMethodInNonBlockingContext")
@OptIn(ExperimentalCoroutinesApi::class)
class UserServiceTest : ServiceTest() {
    private lateinit var service: UserService

    override fun setUp() {
        super.setUp()

        service = retrofit.create(UserService::class.java)
    }

    @Test
    fun getUsers_success_assertThat() = runTest {
        // Given
        mockWebServer.enqueue(success("user/get_users_response"))
        val page = 1
        val perPage = 30
        // When
        val response = service.getUsers(page, perPage)
        // Then
        val request = mockWebServer.takeRequest()
        assertThat(request.method).matches("GET")
        val path = "/users?page=$page&per_page=$perPage"
        assertThat(request.path).isEqualTo(path)

        ServiceResponseChecker.checkData(response)
    }
}
