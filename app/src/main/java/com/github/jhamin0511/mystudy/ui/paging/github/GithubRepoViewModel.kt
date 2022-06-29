package com.github.jhamin0511.mystudy.ui.paging.github

import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

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
    val items = repository.getRepositories("")
    // endregion
}
