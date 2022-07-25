package com.github.jhamin0511.mystudy.ui.study

import android.view.ViewGroup
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.widget.recycler.BaseAdapter
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.HolderItemClickListener

class StudyAdapter(
    private val studyClickListener: HolderItemClickListener
) : BaseAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view = onCreateView(parent, R.layout.item_study)

        return StudyHolder(view, studyClickListener)
    }
}
