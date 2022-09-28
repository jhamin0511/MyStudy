package com.github.jhamin0511.sample.navigationflow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.app.common.viewmodel.Event
import com.github.jhamin0511.app.common.viewmodel.event
import com.github.jhamin0511.sample.navigationflow.notification.Notification.BEER
import com.github.jhamin0511.sample.navigationflow.notification.Notification.MAKGEOLLI
import com.github.jhamin0511.sample.navigationflow.notification.Notification.SOJU
import com.github.jhamin0511.sample.navigationflow.notification.Notification.WHISKEY

class MainViewModel : ViewModel() {
    // region Binding
    // endregion

    // region Observe
    val observeBottomIndex = MutableLiveData<Event<Int>>()
    // endregion

    // region Model
    fun bottomNavigationIndex(index: String?) {
        when (index) {
            MAKGEOLLI -> {
                observeBottomIndex.event(R.id.makgeolliFragment)
            }
            SOJU -> {
                observeBottomIndex.event(R.id.sojuFragment)
            }
            BEER -> {
                observeBottomIndex.event(R.id.beerFragment)
            }
            WHISKEY -> {
                observeBottomIndex.event(R.id.whiskeyFragment)
            }
        }
    }
    // endregion
}
