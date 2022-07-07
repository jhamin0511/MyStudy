package com.github.jhamin0511.mystudy.repository.paging

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.network.response.UserResponse
import com.github.jhamin0511.mystudy.network.service.UserService
import com.github.jhamin0511.mystudy.test.mock
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@OptIn(ExperimentalCoroutinesApi::class)
class UserPagingSourceTest {

    companion object {
        private const val PER_PAGE = 30
        private val ITEMS = listOf(
            UserDto(1, UserType.ONE, 1656946800000, "name1", 1, "introduce")
        )
    }

    private val service: UserService = mock()
    private val pagingSource = UserPagingSource(service)

    @BeforeAll
    fun setUp() = runTest {
        val response = UserResponse(3000, ITEMS)
        Mockito.`when`(service.getUsers(any(), any())).thenReturn(response)
    }

    @Test
    fun load_result_assertThat() = runTest {
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
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun getRefreshKey_assertThat() {
        // Given
        val expected = 1
        val page = PagingSource.LoadResult.Page(
            data = ITEMS,
            prevKey = null,
            nextKey = 2
        )
        val pages = listOf(page)
        val state = PagingState(
            pages = pages,
            anchorPosition = expected,
            config = PagingConfig(PER_PAGE),
            PER_PAGE
        )
        // When
        val actual = pagingSource.getRefreshKey(state)
        // Then
        assertThat(actual).isEqualTo(expected)
    }
}
