package com.github.jhamin0511.mystudy.ui.common

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes

fun Activity.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, duration)
}

fun Activity.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration)
}
