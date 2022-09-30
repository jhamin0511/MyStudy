package com.github.jhamin0511.sample.design.color

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.jhamin0511.app.common.recycler.BaseAdapter
import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.sample.design.databinding.ItemColorBinding

class ColorAdapter : BaseAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemColorBinding.inflate(inflater, parent, false)

        return ColorHolder(binding)
    }
}
