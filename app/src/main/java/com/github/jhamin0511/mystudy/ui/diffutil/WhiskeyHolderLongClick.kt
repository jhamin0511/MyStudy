package com.github.jhamin0511.mystudy.ui.diffutil

import com.github.jhamin0511.mystudy.widget.recycler.HolderLongClickListener
import com.github.jhamin0511.mystudy.widget.recycler.source.SourceQuery

class WhiskeyHolderLongClick(
    private val dataSource: SourceQuery<*>
) : HolderLongClickListener {
    override fun onLongClick(id: Long, position: Int) {
        dataSource.remove(id)
    }
}
