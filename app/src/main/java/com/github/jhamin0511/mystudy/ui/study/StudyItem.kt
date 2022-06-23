package com.github.jhamin0511.mystudy.ui.study

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.vo.Study
import com.github.jhamin0511.mystudy.databinding.ItemStudyBinding
import com.github.jhamin0511.mystudy.widget.recycler.Item

class StudyItem(
    val vo: Study
) : Item<ItemStudyBinding>() {
    val id = vo.id

    override fun getItemLayout() = R.layout.item_study

    override fun bind(binding: ItemStudyBinding, position: Int) {
        binding.vo = vo
    }
}
