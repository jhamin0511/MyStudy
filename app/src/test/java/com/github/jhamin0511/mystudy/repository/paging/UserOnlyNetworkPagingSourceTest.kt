package com.github.jhamin0511.mystudy.repository.paging

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.network.response.UserResponse
import com.github.jhamin0511.mystudy.network.service.UserService
import com.github.jhamin0511.mystudy.repository.user.UserOnlyNetworkPagingSource
import com.github.jhamin0511.mystudy.test.mock
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@OptIn(ExperimentalCoroutinesApi::class)
class UserOnlyNetworkPagingSourceTest {
    private val service: UserService = mock()
    private val pagingSource = UserOnlyNetworkPagingSource(service)
    private val perPage = 30
    private val items = listOf(
        UserDto(1, UserType.ONE, 1656946800000, "name1", 1, "introduce", "content1")
    )
    private val resultItems = listOf(
        UserEntity(1, UserType.ONE, 1656946800000, "name1", 1, "introduce", "content1")
    )

    @Before
    fun setUp() = runTest {
        val response = UserResponse(3000, items, false)
        Mockito.`when`(service.getUsers(any(), any())).thenReturn(response)
    }

    @Test
    fun load_result_assertThat() = runTest {
        // Given
        val expected = PagingSource.LoadResult.Page(
            data = resultItems,
            prevKey = null,
            nextKey = 2
        )
        // When
        val actual = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = perPage,
                placeholdersEnabled = false
            )
        )
        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun getRefreshKey_assertThat() {
        // Given
        val expected = null
        val page = PagingSource.LoadResult.Page(
            data = resultItems,
            prevKey = null,
            nextKey = 2
        )
        val pages = listOf(page)
        val state = PagingState(
            pages = pages,
            anchorPosition = expected,
            config = PagingConfig(perPage),
            perPage
        )
        // When
        val actual = pagingSource.getRefreshKey(state)
        // Then
        assertThat(actual).isEqualTo(expected)
    }
}
