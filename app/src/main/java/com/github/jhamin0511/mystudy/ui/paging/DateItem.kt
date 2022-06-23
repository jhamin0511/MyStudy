package com.github.jhamin0511.mystudy.ui.paging

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ItemDateBinding
import com.github.jhamin0511.mystudy.widget.recycler.Item

class DateItem(
    val date: String
) : Item<ItemDateBinding>() {

    override fun getItemLayout() = R.layout.item_date

    override fun bind(binding: ItemDateBinding, position: Int) {
        binding.date = date
    }
}
