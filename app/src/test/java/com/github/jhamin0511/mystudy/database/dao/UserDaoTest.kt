package com.github.jhamin0511.mystudy.database.dao

import android.content.Context
import androidx.paging.PagingSource
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.database.AppDatabase
import com.google.common.truth.Truth.assertThat
import java.io.IOException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class UserDaoTest {
    private lateinit var dao: UserDao
    private lateinit var database: AppDatabase
    private val expected = listOf(
        UserEntity(1, UserType.ONE, System.currentTimeMillis(), "name", 21, "introduce", "content")
    )
    private val loadParams = PagingSource.LoadParams.Refresh<Int>(
        key = null,
        loadSize = 30,
        placeholdersEnabled = false
    )

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = database.userDao()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAll_selectAll_assertThat() = runTest {
        // Given
        dao.insertAll(expected)
        // When
        val loadResult = dao.selectAll().load(loadParams) as PagingSource.LoadResult.Page
        val actual = loadResult.data
        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    @Throws(Exception::class)
    fun insertAll_deleteAll_assertThat() = runTest {
        // Given
        dao.insertAll(expected)
        dao.deleteAll()
        // When
        val loadResult = dao.selectAll().load(loadParams) as PagingSource.LoadResult.Page
        val actual = loadResult.data
        // Then
        assertThat(actual).isEmpty()
    }
}
