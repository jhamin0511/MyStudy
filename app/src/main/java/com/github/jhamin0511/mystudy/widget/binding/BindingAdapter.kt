package com.github.jhamin0511.mystudy.widget.binding

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("bindText")
    fun bindText(view: TextView, @StringRes id: Int?) {
        if (id != null) {
            view.setText(id)
        }
    }
}
