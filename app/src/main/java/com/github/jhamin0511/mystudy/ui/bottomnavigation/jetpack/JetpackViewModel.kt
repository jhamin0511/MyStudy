package com.github.jhamin0511.mystudy.ui.bottomnavigation.jetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JetpackViewModel
@Inject constructor() : ViewModel() {
    // region Binding
    val bindCount = MutableLiveData<Int>()

    fun bindClickCount() {
        bindCount.value = ++count
    }
    // endregion

    // region Observe
    // endregion

    // region Model
    private var count = 0
    // endregion
}
