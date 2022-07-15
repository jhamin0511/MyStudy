package com.github.jhamin0511.mystudy.repository.user

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator.MediatorResult
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.database.AppDatabase
import com.github.jhamin0511.mystudy.network.response.UserResponse
import com.github.jhamin0511.mystudy.network.service.UserService
import com.github.jhamin0511.mystudy.test.mock
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import java.io.IOException
import java.net.HttpURLConnection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import retrofit2.HttpException
import retrofit2.Response

@ExperimentalPagingApi
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class UserRemoteMediatorTest {
    private val service: UserService = mock()
    private lateinit var database: AppDatabase
    private lateinit var mediator: UserRemoteMediator
    private val perPage = 30
    private val pagingState = PagingState<Int, UserEntity>(
        listOf(),
        null,
        PagingConfig(perPage),
        perPage
    )
    private val items = listOf(
        UserDto(1, UserType.ONE, 1656946800000, "name1", 1, "introduce")
    )

    @Before
    fun setUp() = runTest {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        mediator = UserRemoteMediator(service, database)
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun refreshLoad_hasRemoteData_assertThat() = runTest {
        // Given
        val response = UserResponse(3000, items, false)
        Mockito.`when`(service.getUsers(any(), any())).thenReturn(response)
        // When
        val actual = mediator.load(LoadType.REFRESH, pagingState)
        // Then
        assertThat(actual).isInstanceOf(MediatorResult.Success::class.java)
        assertThat((actual as MediatorResult.Success).endOfPaginationReached).isFalse()
    }

    @Test
    @Throws(Exception::class)
    fun refreshLoad_noneRemoteData_assertThat() = runTest {
        // Given
        val response = UserResponse(0, emptyList(), true)
        Mockito.`when`(service.getUsers(any(), any())).thenReturn(response)
        // When
        val actual = mediator.load(LoadType.REFRESH, pagingState)
        // Then
        assertThat(actual).isInstanceOf(MediatorResult.Success::class.java)
        assertThat((actual as MediatorResult.Success).endOfPaginationReached).isTrue()
    }

    @Test
    @Throws(Exception::class)
    fun refreshLoad_error_assertThat() = runTest {
        // Given
        val responseBody = "HttpError".toResponseBody("text/plain".toMediaType())
        val errorResponse = Response.error<String>(HttpURLConnection.HTTP_BAD_REQUEST, responseBody)
        Mockito.doAnswer {
            throw HttpException(errorResponse)
        }.`when`(service).getUsers(any(), any())
        // When
        val actual = mediator.load(LoadType.REFRESH, pagingState)
        // Then
        assertThat(actual).isInstanceOf(MediatorResult.Error::class.java)
    }
}
