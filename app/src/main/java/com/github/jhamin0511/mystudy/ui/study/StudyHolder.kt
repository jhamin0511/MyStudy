package com.github.jhamin0511.mystudy.ui.study

import android.view.View
import com.github.jhamin0511.mystudy.databinding.ItemStudyBinding
import com.github.jhamin0511.mystudy.widget.recycler2.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler2.Item
import com.github.jhamin0511.mystudy.widget.recycler2.ItemClickListener

class StudyHolder(
    view: View,
    private val studyClickListener: ItemClickListener<StudyItem>
) : BaseHolder<ItemStudyBinding>(view) {

    init {
        binding.root.setOnClickListener {
            studyClickListener.onClick(item, adapterPosition)
        }
    }

    lateinit var item: StudyItem

    override fun bind(item: Item) {
        this.item = item as StudyItem
        binding.item = item
    }
}
