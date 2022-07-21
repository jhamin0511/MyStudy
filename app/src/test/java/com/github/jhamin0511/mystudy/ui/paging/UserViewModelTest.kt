package com.github.jhamin0511.mystudy.ui.paging

import androidx.paging.AsyncPagingDataDiffer
import androidx.paging.PagingData
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.repository.user.UserRepository
import com.github.jhamin0511.mystudy.test.UpdateCallBack
import com.github.jhamin0511.mystudy.test.mock
import com.github.jhamin0511.mystudy.ui.paging.user.UserAdapter
import com.github.jhamin0511.mystudy.ui.paging.user.UserViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class UserViewModelTest {
    private val testScope = TestScope()
    private val testDispatcher = StandardTestDispatcher(testScope.testScheduler)
    private val repository: UserRepository = mock()
    private val viewModel = UserViewModel(repository)

    @Before
    internal fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    internal fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun transformItem() = testScope.runTest {
        // Given
        val list = listOf(
            UserEntity(1, UserType.ONE, 1656946800000, "name1", 1, "introduce1", "content1"),
            UserEntity(2, UserType.TWO, 1656944800000, "name2", 2, "introduce2", "content2"),
        )
        val data = PagingData.from(list)
        val differ = AsyncPagingDataDiffer(
            diffCallback = UserAdapter.DIFF_CALLBACK,
            updateCallback = UpdateCallBack(),
            workerDispatcher = Dispatchers.Main
        )
        // When
        val transform = viewModel.transformItem(data)
        differ.submitData(transform)
        advanceUntilIdle()
        val actual = differ.snapshot().items
        // Then
        assertThat(actual).hasSize(4)
    }
}
