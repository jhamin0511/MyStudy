package com.github.jhamin0511.mystudy.repository.user

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.database.AppDatabase
import com.github.jhamin0511.mystudy.network.service.UserService
import javax.inject.Inject

private const val PER_PAGE = 50

class UserRepository
@Inject constructor(
    private val service: UserService,
    private val database: AppDatabase
) {
    private val userDao = database.userDao()

    fun getUsersOnlyNetworkPagingSource(): Pager<Int, UserEntity> {
        val config = PagingConfig(PER_PAGE)

        return Pager(config) {
            UserPagingSource(service)
        }
    }

    fun getUserOnlyDatabasePagingSource(): Pager<Int, UserEntity> {
        val config = PagingConfig(
            pageSize = PER_PAGE,
            enablePlaceholders = false
        )

        return Pager(config) {
            userDao.selectAll()
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    fun getUsersNetDbPagingSource(): Pager<Int, UserEntity> {
        val config = PagingConfig(
            pageSize = PER_PAGE
        )

        return Pager(
            config = config,
            remoteMediator = UserRemoteMediator(service, database)
        ) {
            userDao.selectAll()
        }
    }
}
