package com.github.jhamin0511.mystudy.ui.study

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudyViewModel
@Inject constructor() : ViewModel() {

    // region Binding
    // endregion

    // region Observe
    val observeStudies = MutableLiveData<List<StudyItem>>()
    // endregion

    // region Model
    private val items = listOf(
        StudyItem(R.string.notification, R.id.action_studyFragment_to_notificationFragment),
        StudyItem(R.string.github_repository, R.id.action_studyFragment_to_githubRepoFragment),
        StudyItem(R.string.user_paging, R.id.action_studyFragment_to_userFragment),
        StudyItem(R.string.selection, R.id.action_studyFragment_to_selectionFragment),
        StudyItem(R.string.diffutil, R.id.action_studyFragment_to_diffutilFragment),
    )

    init {
        observeStudies.value = items
    }
    // endregion
}
