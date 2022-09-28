package com.github.jhamin0511.mystudy.ui.notification.channel

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.core.app.NotificationManagerCompat.IMPORTANCE_DEFAULT
import androidx.core.app.NotificationManagerCompat.IMPORTANCE_HIGH
import androidx.core.app.NotificationManagerCompat.IMPORTANCE_LOW
import androidx.core.app.NotificationManagerCompat.IMPORTANCE_MIN
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.ui.notification.channel.ChannelGroup.IMPORTANCE

enum class Channel(
    val id: String,
    @StringRes
    val nameRes: Int,
    @StringRes
    val description: Int,
    val importance: Int,
    val group: ChannelGroup = ChannelGroup.NORMAL
) {
    STYLE(
        "channel_style",
        R.string.channel_style,
        R.string.channel_style_description,
        IMPORTANCE_DEFAULT
    ),
    NORMAL(
        "channel_normal",
        R.string.channel_normal,
        R.string.channel_normal_description,
        IMPORTANCE_DEFAULT
    ),
    Group(
        "channel_group",
        R.string.channel_group,
        R.string.channel_group_description,
        IMPORTANCE_DEFAULT
    ),
    HIGH(
        "channel_high",
        R.string.channel_high,
        R.string.channel_high_description,
        IMPORTANCE_HIGH,
        IMPORTANCE
    ),
    DEFAULT(
        "channel_default",
        R.string.channel_default,
        R.string.channel_default_description,
        IMPORTANCE_DEFAULT,
        IMPORTANCE
    ),
    LOW(
        "channel_low",
        R.string.channel_low,
        R.string.channel_low_description,
        IMPORTANCE_LOW,
        IMPORTANCE
    ),
    MIN(
        "channel_min",
        R.string.channel_min,
        R.string.channel_min_description,
        IMPORTANCE_MIN,
        IMPORTANCE
    );

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun create(context: Context) {
            val channels = values().map {
                val name = context.getString(it.nameRes)
                NotificationChannel(it.id, name, it.importance).apply {
                    group = it.group.id
                }
            }
            val manger = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manger.createNotificationChannels(channels)
        }
    }
}
