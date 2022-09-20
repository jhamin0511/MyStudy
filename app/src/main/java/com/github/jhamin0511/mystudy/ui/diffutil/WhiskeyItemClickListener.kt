package com.github.jhamin0511.mystudy.ui.diffutil

import androidx.annotation.DrawableRes
import androidx.navigation.NavController
import com.github.jhamin0511.mystudy.widget.source.SourceQuery

interface WhiskeyItemClickListener {
    fun onClickImage(@DrawableRes resource: Int)
    fun onClickSelect(id: Long): Boolean
}

class WhiskeyItemClick(
    private val navController: NavController,
    private val query: SourceQuery<*>
) : WhiskeyItemClickListener {
    override fun onClickImage(resource: Int) {
        val action =
            DiffutilFragmentDirections.actionDiffutilFragmentToImageDetailFragment(resource)
        navController.navigate(action)
    }

    override fun onClickSelect(id: Long): Boolean {
        return query.selected(id)
    }
}
