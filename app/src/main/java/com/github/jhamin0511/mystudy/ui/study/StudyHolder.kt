package com.github.jhamin0511.mystudy.ui.study

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.HolderItemClickListener
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.databinding.ItemStudyBinding

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
