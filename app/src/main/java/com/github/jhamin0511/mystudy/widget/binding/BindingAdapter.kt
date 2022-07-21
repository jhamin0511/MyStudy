package com.github.jhamin0511.mystudy.widget.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.github.jhamin0511.mystudy.widget.setVisible

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

    @JvmStatic
    @BindingAdapter("bindVisible")
    fun bindVisible(view: View, visible: Boolean) {
        view.setVisible(visible)
    }
}
