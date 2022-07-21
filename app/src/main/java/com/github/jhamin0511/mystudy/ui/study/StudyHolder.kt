package com.github.jhamin0511.mystudy.ui.study

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.databinding.ItemStudyBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick

class StudyHolder(
    view: View,
    onClick: ItemClick
) : BaseHolder(view, onClick) {
    private val binding: ItemStudyBinding = DataBindingUtil.bind(view)!!

    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as StudyItem
    }
}
