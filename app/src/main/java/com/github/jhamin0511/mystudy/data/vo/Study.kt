package com.github.jhamin0511.mystudy.data.vo

import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Study(
    val id: Long,
    @StringRes
    val nameRes: Int,
    @IntegerRes
    val navigateRes: Int
)
