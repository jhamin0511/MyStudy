package com.github.jhamin0511.mystudy.widget.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.jhamin0511.app.common.recycler.paging.AppendLoader
import com.github.jhamin0511.mystudy.widget.setVisible
import timber.log.Timber

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

    @JvmStatic
    @BindingAdapter("bindSelected")
    fun bindSelected(view: View, selected: Boolean) {
        view.isSelected = selected
    }

    @JvmStatic
    @BindingAdapter("bindImage")
    fun bindImage(view: ImageView, @DrawableRes res: Int) {
        view.setImageResource(res)
    }

    @JvmStatic
    @BindingAdapter("bindInfiniteScroll")
    fun setBindInfiniteScroll(view: RecyclerView, listener: AppendLoader) {
        view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    Timber.i("최하단")
                    listener.onLoad()
                }
            }
        })
    }
}
