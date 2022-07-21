package com.github.jhamin0511.mystudy.repository.paging

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.network.response.UserResponse
import com.github.jhamin0511.mystudy.network.service.UserService
import com.github.jhamin0511.mystudy.repository.user.UserPagingSource
import com.github.jhamin0511.mystudy.test.mock
import com.github.jhamin0511.mystudy.ui.paging.PER_PAGE
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import java.net.HttpURLConnection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import org.mockito.Mockito
import retrofit2.HttpException
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class UserPagingSourceTest {
    private val service: UserService = mock()
    private val pagingSource = UserPagingSource(service)
    private val params = PagingSource.LoadParams.Refresh<Int>(
        key = null,
        loadSize = PER_PAGE,
        placeholdersEnabled = false
    )
    private val items = listOf(
        UserDto(1, UserType.ONE, 1656946800000, "name1", 1, "introduce", "content1")
    )
    private val resultItems = listOf(
        UserEntity(1, UserType.ONE, 1656946800000, "name1", 1, "introduce", "content1")
    )

    @Test
    fun load_success_assertThat() = runTest {
        // Given
        val response = UserResponse(3000, items, false)
        Mockito.`when`(service.getUsers(any(), any())).thenReturn(response)

        val expected = PagingSource.LoadResult.Page(
            data = resultItems,
            prevKey = null,
            nextKey = 2
        )
        // When
        val actual = pagingSource.load(params)
        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun load_error_assertThat() = runTest {
        // Given
        val responseBody = "HttpError".toResponseBody("text/plain".toMediaType())
        val errorResponse = Response.error<String>(HttpURLConnection.HTTP_BAD_REQUEST, responseBody)
        val httpException = HttpException(errorResponse)
        Mockito.`when`(service.getUsers(any(), any())).thenThrow(httpException)

        val expected = PagingSource.LoadResult.Error<Int, UserEntity>(httpException)
        // When
        val actual = pagingSource.load(params)
        println((actual as PagingSource.LoadResult.Error).toString())
        println((actual as PagingSource.LoadResult.Error).throwable)
        println(actual.toString())
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
            config = PagingConfig(PER_PAGE),
            PER_PAGE
        )
        // When
        val actual = pagingSource.getRefreshKey(state)
        // Then
        assertThat(actual).isEqualTo(expected)
    }
}
