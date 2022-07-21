package com.github.jhamin0511.mystudy.ui.notification

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.key.DESCRIPTION
import com.github.jhamin0511.mystudy.key.TITLE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationResultViewModel
@Inject constructor(
) : ViewModel() {

    // region Binding
    val bindTitle = MutableLiveData<String>()
    val bindDescription = MutableLiveData<String>()
    // endregion

    // region Observe
    // endregion

    // region Model
    fun initModel(args: Bundle) {
        bindTitle.value = args.getString(TITLE)
        bindDescription.value = args.getString(DESCRIPTION)
    }
    // endregion
}
