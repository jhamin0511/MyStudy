package com.github.jhamin0511.mystudy.ui.diffutil

import androidx.annotation.DrawableRes
import androidx.navigation.NavController

interface WhiskeyItemClickListener {
    fun onClickImage(@DrawableRes resource: Int)
}

class WhiskeyItemClick(
    private val navController: NavController,
) : WhiskeyItemClickListener {
    override fun onClickImage(resource: Int) {
        val action =
            DiffutilFragmentDirections.actionDiffutilFragmentToImageDetailFragment(resource)
        navController.navigate(action)
    }
}
