package com.github.jhamin0511.mystudy.ui.paging.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.jhamin0511.mystudy.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val PAGE_SIZE = 30

@HiltViewModel
class GithubRepoViewModel
@Inject constructor(
    repository: GithubRepository
) : ViewModel() {
    // region Binding
    // endregion

    // region Observe
    // endregion

    // region Model
    val items = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
        pagingSourceFactory = { repository.getGithubRepositoryPagingSource("Github") }
    ).flow.cachedIn(viewModelScope)
    // endregion
}
