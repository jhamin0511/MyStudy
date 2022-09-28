package com.github.jhamin0511.sample.design

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.jhamin0511.app.common.recycler.BaseAdapter
import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.HolderItemClickListener
import com.github.jhamin0511.sample.design.databinding.ItemElementBinding

class ElementAdapter(
    private val itemClick: HolderItemClickListener
) : BaseAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemElementBinding.inflate(inflater, parent, false)

        return ElementHolder(binding, itemClick)
    }
}
