package com.github.jhamin0511.mystudy.widget

import android.view.View

fun View.setVisibleGone(value: CharSequence?) {
    this.visibility = if (value?.isEmpty() == true) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

fun View.setVisible(value: Boolean?) {
    this.visibility = if (value == true) {
        View.VISIBLE
    } else {
        View.GONE
    }
}
