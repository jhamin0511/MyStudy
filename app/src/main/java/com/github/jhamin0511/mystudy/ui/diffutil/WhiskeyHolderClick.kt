package com.github.jhamin0511.mystudy.ui.diffutil

import androidx.navigation.NavController
import com.github.jhamin0511.app.common.recycler.HolderClickListener
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.widget.source.DataSource

class WhiskeyHolderClick(
    private val navController: NavController,
    private val dataSource: DataSource<WhiskeyDto>
) : HolderClickListener {
    override fun onClick(id: Long, position: Int) {
        val whiskey = dataSource.get(id)
        if (whiskey != null) {
            val action =
                DiffutilFragmentDirections.actionDiffutilFragmentToWhiskeyDetailFragment(whiskey)
            navController.navigate(action)
        }
    }
}
