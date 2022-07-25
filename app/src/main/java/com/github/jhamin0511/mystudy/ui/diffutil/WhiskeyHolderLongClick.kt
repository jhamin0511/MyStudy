package com.github.jhamin0511.mystudy.ui.diffutil

import com.github.jhamin0511.mystudy.widget.recycler.HolderLongClickListener

class WhiskeyHolderLongClick(
    private val dataSource: WhiskeyDataSource
) : HolderLongClickListener {
    override fun onLongClick(id: Long, position: Int) {
        dataSource.remove(id)
    }
}
