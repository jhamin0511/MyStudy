package com.github.jhamin0511.mystudy.ui.refresh

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class RefreshViewModel
@Inject constructor(
    private val oneTab: RefreshTabStateWithDI.One,
    private val twoTab: RefreshTabStateWithDI.Two,
    private val threeTab: RefreshTabStateWithDI.Three,
    private val fourTab: RefreshTabStateWithDI.Four
) : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData<Boolean>()

    fun bindClickRefreshOne() {
        refreshTab(oneTab, RefreshTabStateWithEnum.One)
    }

    fun bindClickRefreshTwo() {
        refreshTab(twoTab, RefreshTabStateWithEnum.Two)
    }

    fun bindClickRefreshThree() {
        refreshTab(threeTab, RefreshTabStateWithEnum.Three)
    }

    fun bindClickRefreshFour() {
        refreshTab(fourTab, RefreshTabStateWithEnum.Fore)
    }
    // endregion

    // region Observe
    // endregion

    // region Model
    private var type = RefreshType.ALWAYS

    fun changeType(type: RefreshType) {
        this.type = type
    }

    fun applyRefresh(position: Int) {
        Timber.i("type : $type")
        val isRefresh = when (type) {
            RefreshType.ALWAYS -> true
            RefreshType.DI -> {
                when (position) {
                    RefreshPosition.ONE -> oneTab
                    RefreshPosition.TWO -> twoTab
                    RefreshPosition.THREE -> threeTab
                    else -> fourTab
                }.isRefresh()
            }
            RefreshType.ENUM -> {
                when (position) {
                    RefreshPosition.ONE -> RefreshTabStateWithEnum.One
                    RefreshPosition.TWO -> RefreshTabStateWithEnum.Two
                    RefreshPosition.THREE -> RefreshTabStateWithEnum.Three
                    else -> RefreshTabStateWithEnum.Fore
                }.isRefresh()
            }
        }

        Timber.i("isRefresh : $isRefresh")
        if (isRefresh) {
            viewModelScope.launch {
                bindLoading.value = true
                delay(NETWORK_DELAY_TIME)
                bindLoading.value = false
            }
        }
    }

    private fun refreshTab(
        di: RefreshTabStateWithDI,
        enum: RefreshTabStateWithEnum
    ) {
        when (type) {
            RefreshType.ALWAYS -> {
            }
            RefreshType.DI -> {
                Timber.i("tab : $di")
                di.expire()
            }
            RefreshType.ENUM -> {
                Timber.i("tab : ${RefreshTabStateWithEnum.One}")
                enum.expire()
            }
        }
    }
    // endregion
}
