package com.github.jhamin0511.mystudy.ui.paging

import android.content.Context
import android.widget.Toast
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.github.jhamin0511.mystudy.R
import java.net.UnknownHostException

/**
 *
 * 페이징에서 발생되는 공통적인 에러를 처리 할 수 있도록 에러를 제한
 *
 * */
class PagingErrorHandler(
    private val context: Context
) {
    private var toast: Toast? = null

    fun showToast(action: CombinedLoadStates) {
        val errorState = action.refresh as? LoadState.Error
            ?: action.prepend as? LoadState.Error
            ?: action.append as? LoadState.Error

        if (errorState != null && toast == null) {
            val message = when (errorState.error) {
                is UnknownHostException -> R.string.error_internet_connect
                else -> R.string.error_unknown
            }
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            toast?.addCallback(object : Toast.Callback() {
                override fun onToastHidden() {
                    toast = null
                }
            })
            toast?.show()
        }
    }
}
