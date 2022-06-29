package com.github.jhamin0511.mystudy.ui.study

import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import com.github.jhamin0511.mystudy.widget.recycler.Item

class StudyItem(
    @StringRes
    val nameRes: Int,
    @IntegerRes
    val navigateRes: Int
) : Item
