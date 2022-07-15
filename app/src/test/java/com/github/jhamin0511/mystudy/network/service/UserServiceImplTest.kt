package com.github.jhamin0511.mystudy.network.service

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserServiceImplTest {

    private val service = UserServiceImpl()

    @Test
    fun getUsers_success() = runTest {
        // Given
        var page = 1
        val perPage = 30
        // When
        val response1 = service.getUsers(page++, perPage)
        val response2 = service.getUsers(page++, perPage)
        val response3 = service.getUsers(page, perPage)
        // Then
        assertThat(response1.users).hasSize(30)
        assertThat(response1.users[0].name).isEqualTo("name 1")
        assertThat(response2.users).hasSize(30)
        assertThat(response2.users[0].name).isEqualTo("name 31")
        assertThat(response3.users).hasSize(30)
        assertThat(response3.users[0].name).isEqualTo("name 61")
    }
}
