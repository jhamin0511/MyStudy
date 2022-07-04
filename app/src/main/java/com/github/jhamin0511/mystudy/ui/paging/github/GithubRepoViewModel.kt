package com.github.jhamin0511.mystudy.ui.paging.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.github.jhamin0511.mystudy.repository.github.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class GithubRepoViewModel
@Inject constructor(
    repository: GithubRepository
) : ViewModel() {
    // region Binding
    val bindSearchKeyword = MutableStateFlow("Android")
    // endregion

    // region Observe
    // endregion

    // region Model
    val items = repository.getGithubRepository(bindSearchKeyword)
        .cachedIn(viewModelScope)
    // endregion
}
