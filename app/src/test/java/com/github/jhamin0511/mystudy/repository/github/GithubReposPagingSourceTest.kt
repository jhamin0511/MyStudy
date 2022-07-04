package com.github.jhamin0511.mystudy.repository.github

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import com.github.jhamin0511.mystudy.mock
import com.github.jhamin0511.mystudy.network.response.GithubRepositoryResponse
import com.github.jhamin0511.mystudy.network.service.GithubService
import kotlin.test.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@OptIn(ExperimentalCoroutinesApi::class)
class GithubReposPagingSourceTest {

    companion object {
        private const val KEYWORD = "Android"
        private const val PAGE = 1
        private const val PER_PAGE = 30
        private val ITEMS = listOf(
            GithubRepoDto(1, "name1", "url1", "desc1", 1, 1, "lang1"),
            GithubRepoDto(2, "name2", "url2", "desc2", 2, 2, "lang2"),
            GithubRepoDto(3, "name3", "url3", "desc3", 3, 3, "lang3"),
            GithubRepoDto(4, "name4", "url4", "desc4", 4, 4, "lang4"),
            GithubRepoDto(5, "name5", "url5", "desc5", 5, 5, "lang5")
        )
    }

    private val service: GithubService = mock()
    private val pagingSource = GithubReposPagingSource(service, KEYWORD)

    @Before
    fun setUp() = runTest {
        val response = GithubRepositoryResponse(
            3000,
            ITEMS
        )
        Mockito.`when`(service.getSearchRepository(KEYWORD, PAGE, PER_PAGE)).thenReturn(response)
    }

    @Test
    fun load_result_assertEquals() = runTest {
        // Given
        val expected = PagingSource.LoadResult.Page(
            data = ITEMS,
            prevKey = null,
            nextKey = 2
        )
        // When
        val actual = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = PER_PAGE,
                placeholdersEnabled = false
            )
        )
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun getRefreshKey_assertEquals() {
        // Given
        val state = PagingState<Int, GithubRepoDto>(
            pages = listOf(),
            anchorPosition = 1,
            config = PagingConfig(PER_PAGE),
            PER_PAGE
        )
        // When
        val key = pagingSource.getRefreshKey(state)
        // Then
        assertEquals(1, key)
    }
}
