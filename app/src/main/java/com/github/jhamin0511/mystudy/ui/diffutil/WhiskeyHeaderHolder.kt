package com.github.jhamin0511.mystudy.ui.diffutil

import com.github.jhamin0511.mystudy.BR
import com.github.jhamin0511.mystudy.databinding.ItemWhiskeyHeaderBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item

class WhiskeyHeaderHolder(
    private val binding: ItemWhiskeyHeaderBinding
) : BaseHolder(binding.root) {

    override fun bind(item: Item) {
        super.bind(item)

        binding.setVariable(BR.item, item)
    }
}
