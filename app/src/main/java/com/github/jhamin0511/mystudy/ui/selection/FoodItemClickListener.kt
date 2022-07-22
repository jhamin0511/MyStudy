package com.github.jhamin0511.mystudy.ui.selection

import androidx.annotation.DrawableRes

interface FoodItemClickListener {
    fun onClickImage(@DrawableRes resource: Int)
}
