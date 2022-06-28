package com.github.jhamin0511.mystudy.ui.study

import android.view.ViewGroup
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.widget.recycler2.BaseAdapter
import com.github.jhamin0511.mystudy.widget.recycler2.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler2.ItemClickListener

class StudyAdapter(
    private val studyClickListener: ItemClickListener<StudyItem>
) : BaseAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<*> {
        val view = onCreateView(parent, R.layout.item_study)

        return StudyHolder(view, studyClickListener)
    }
}
