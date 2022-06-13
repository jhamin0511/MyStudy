package com.github.jhamin0511.mystudy.ui.study

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudyViewModel
@Inject constructor(
    application: Application
) : ViewModel() {

    // region Binding
    // endregion

    // region Observe
    val observeStudies = MutableLiveData<Event<List<String>>>()

    init {
        val items = application.resources.getStringArray(R.array.study).toList()
        observeStudies.event(items)
    }
    // endregion

    // region Model
    // endregion
}
