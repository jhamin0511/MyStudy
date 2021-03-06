package com.github.jhamin0511.mystudy.ui.study

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.databinding.ItemStudyBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.HolderItemClickListener
import com.github.jhamin0511.mystudy.widget.recycler.Item

class StudyHolder(
    view: View,
    itemClick: HolderItemClickListener
) : BaseHolder(
    view,
    itemClick = itemClick
) {
    private val binding: ItemStudyBinding = DataBindingUtil.bind(view)!!

    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as StudyItem
    }
}
