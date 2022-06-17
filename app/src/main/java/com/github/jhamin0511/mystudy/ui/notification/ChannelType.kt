package com.github.jhamin0511.mystudy.ui.notification

import androidx.annotation.StringRes
import com.github.jhamin0511.mystudy.R

enum class ChannelType(
    @StringRes
    val channel: String,
    @StringRes
    val channelName: Int,
) {
    NORMAL("channel_normal", R.string.channel_normal),
    Group("channel_group", R.string.channel_group);
}
