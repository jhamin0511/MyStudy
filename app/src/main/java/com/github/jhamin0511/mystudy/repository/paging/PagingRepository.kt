package com.github.jhamin0511.mystudy.repository.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.network.service.UserService
import javax.inject.Inject
import javax.inject.Singleton

private const val PER_PAGE = 30

@Singleton
class PagingRepository
@Inject constructor(
    private val service: UserService
) {
    fun getUsersPagingSource(): Pager<Int, UserDto> {
        return Pager(
            config = PagingConfig(PER_PAGE, enablePlaceholders = false, initialLoadSize = PER_PAGE),
            pagingSourceFactory = {
                UserPagingSource(service)
            }
        )
    }
}
