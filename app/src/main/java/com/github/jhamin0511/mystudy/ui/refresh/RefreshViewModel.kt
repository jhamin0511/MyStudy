package com.github.jhamin0511.mystudy.ui.refresh

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class RefreshViewModel
@Inject constructor() : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData<Boolean>()
    // endregion

    // region Observe
    // endregion

    // region Model
    fun applyAlwaysRefresh() {
        viewModelScope.launch {
            bindLoading.value = true
            delay(NETWORK_DELAY_TIME)
            bindLoading.value = false
        }
    }
    // endregion
}
