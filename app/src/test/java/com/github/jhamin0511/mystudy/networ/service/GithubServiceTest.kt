package com.github.jhamin0511.mystudy.networ.service

import com.github.jhamin0511.mystudy.network.service.GithubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class GithubServiceTest : ServiceTest() {
    private lateinit var service: GithubService

    override fun setUp() {
        super.setUp()

        service = retrofit.create(GithubService::class.java)
    }

    @DisplayName("GET Github Repository Response Success")
    @Test
    fun getSearchRepository_success() = runTest {
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
        val path = "search/repositories?page=$page&per_page=$perPage&sort=stars&q=$keyword"
        assertThat(request.path).matches(path)

        assertThat(response.total).isEqualTo(34110)
        assertThat(response.items.size).isEqualTo(30)
    }
}
