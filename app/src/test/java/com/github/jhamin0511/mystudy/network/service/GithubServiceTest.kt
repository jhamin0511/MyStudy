package com.github.jhamin0511.mystudy.network.service

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@Suppress("BlockingMethodInNonBlockingContext")
@OptIn(ExperimentalCoroutinesApi::class)
class GithubServiceTest : ServiceTest() {
    private lateinit var service: GithubService

    override fun setUp() {
        super.setUp()

        service = retrofit.create(GithubService::class.java)
    }

    @Test
    fun getSearchRepository_success_assertThat() = runTest {
        // Given
        mockWebServer.enqueue(success("github/get_repository_response"))
        val page = 1
        val perPage = 30
        val keyword = "Github"
        // When
        val response = service.getSearchRepository(keyword, page, perPage)
        // Then
        val request = mockWebServer.takeRequest()
        assertThat(request.method).matches("GET")
        val path = "/search/repositories?sort=stars&q=$keyword&page=$page&per_page=$perPage"
        assertThat(request.path).isEqualTo(path)

        assertThat(response.total).isEqualTo(34110)
        assertThat(response.items).hasSize(30)
    }
}
