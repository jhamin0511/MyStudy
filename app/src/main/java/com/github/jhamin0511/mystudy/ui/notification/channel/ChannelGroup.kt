package com.github.jhamin0511.mystudy.ui.notification.channel

import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import com.github.jhamin0511.mystudy.R

enum class ChannelGroup(
    val id: String,
    @StringRes
    val nameRes: Int
) {
    NORMAL("group_normal", R.string.channel_group_normal),
    IMPORTANCE("group_importance", R.string.channel_group_importance);

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun create(context: Context) {
            val groups = values().map {
                val name = context.getString(it.nameRes)
                NotificationChannelGroup(it.id, name)
            }
            val manger = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manger.createNotificationChannelGroups(groups)
        }
    }
}
