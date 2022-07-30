package com.github.jhamin0511.mystudy.ui.paging.animal

import com.github.jhamin0511.mystudy.BR
import com.github.jhamin0511.mystudy.databinding.ItemAnimalBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item

class AnimalHolder(
    private val binding: ItemAnimalBinding
) : BaseHolder(binding.root) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.setVariable(BR.item, item)
    }
}
