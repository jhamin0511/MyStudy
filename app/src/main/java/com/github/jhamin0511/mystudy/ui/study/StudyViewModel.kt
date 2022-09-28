package com.github.jhamin0511.mystudy.ui.study

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private val items = listOf(
    StudyItem(R.string.notification, R.id.action_studyFragment_to_notificationFragment),
    StudyItem(R.string.github_repository, R.id.action_studyFragment_to_githubRepoFragment),
    StudyItem(R.string.user_paging, R.id.action_studyFragment_to_userFragment),
    StudyItem(R.string.selection, R.id.action_studyFragment_to_selectionFragment),
    StudyItem(R.string.diffutil, R.id.action_studyFragment_to_diffutilFragment),
    StudyItem(R.string.custom_paging, R.id.action_studyFragment_to_animalFragment),
    StudyItem(R.string.pass_bundle, R.id.action_studyFragment_to_passFragment),
    StudyItem(R.string.savedstatehandle, R.id.action_studyFragment_to_livedataFragment),
    StudyItem(R.string.bottom_navigation, R.id.action_studyFragment_to_bottomNavigationFragment),
    StudyItem(R.string.bottom_nav_refresh, R.id.action_studyFragment_to_refreshNavigationFragment),
    StudyItem(R.string.binding_leak, R.id.action_studyFragment_to_bindingLeakFragment)
)

@HiltViewModel
class StudyViewModel
@Inject constructor(
) : ViewModel() {

    // region Binding
    // endregion

    // region Observe
    val observeItems = MutableLiveData(items)
    // endregion

    // region Model
    // endregion
}
