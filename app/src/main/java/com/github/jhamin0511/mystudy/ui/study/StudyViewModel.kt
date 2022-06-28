package com.github.jhamin0511.mystudy.ui.study

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudyViewModel
@Inject constructor() : ViewModel() {

    // region Binding
    // endregion

    // region Observe
    val observeStudies = MutableLiveData<Event<List<StudyItem>>>()

    init {
        val items = listOf(
            StudyItem(1, R.string.notification, R.id.action_studyFragment_to_notificationFragment),
            StudyItem(2, R.string.paging, R.id.action_studyFragment_to_pagingFragment)
        )
        observeStudies.event(items)
    }
    // endregion

    // region Model
    // endregion
}
