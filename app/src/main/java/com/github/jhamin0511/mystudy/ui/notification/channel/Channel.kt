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
    val importance: Int,
    val group: ChannelGroup = ChannelGroup.NORMAL
) {
    NORMAL("channel_normal", R.string.channel_normal, IMPORTANCE_DEFAULT),
    Group("channel_group", R.string.channel_group, IMPORTANCE_DEFAULT),
    HIGH("channel_high", R.string.channel_high, IMPORTANCE_HIGH, IMPORTANCE),
    DEFAULT("channel_default", R.string.channel_default, IMPORTANCE_DEFAULT, IMPORTANCE),
    LOW("channel_low", R.string.channel_low, IMPORTANCE_LOW, IMPORTANCE),
    MIN("channel_min", R.string.channel_min, IMPORTANCE_MIN, IMPORTANCE);

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

        @StringRes
        fun getDescription(value: Channel) = when (value) {
            NORMAL -> R.string.channel_normal_description
            Group -> R.string.channel_group_description
            HIGH -> R.string.channel_high_description
            DEFAULT -> R.string.channel_default_description
            LOW -> R.string.channel_low_description
            MIN -> R.string.channel_min_description
        }
    }
}
