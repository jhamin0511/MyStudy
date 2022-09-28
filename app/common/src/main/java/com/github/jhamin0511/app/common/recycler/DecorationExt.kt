package com.github.jhamin0511.app.common.recycler

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.defaultDecoration(context: Context) {
    val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

    this.addItemDecoration(decoration)
}
