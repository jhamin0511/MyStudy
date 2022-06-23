package com.github.jhamin0511.mystudy.widget.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
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

    @JvmStatic
    @BindingAdapter("bindImage")
    fun bindImage(view: ImageView, @DrawableRes id: Int?) {
        if (id != null) {
            view.setImageResource(id)
        }
    }
}
