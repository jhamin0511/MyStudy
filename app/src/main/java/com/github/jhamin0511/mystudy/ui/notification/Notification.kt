package com.github.jhamin0511.mystudy.ui.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_DEFAULT
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.key.DESCRIPTION
import com.github.jhamin0511.mystudy.key.TITLE
import com.github.jhamin0511.mystudy.ui.notification.ChannelType.NORMAL
import com.github.jhamin0511.mystudy.ui.notification.GroupType.GROUP

class Notification(
    private val context: Context
) {

    companion object {
        private const val DEFAULT_ICON = R.mipmap.ic_notification
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(context: Context) {
        val channels = ChannelType.values().map {
            val name = context.getString(it.channelName)
            NotificationChannel(it.channel, name, IMPORTANCE_DEFAULT)
        }
        val manger = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manger.createNotificationChannels(channels)
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel(context)
        }
    }

    private var normalCount = 1

    fun notifyNormal() {
        val name = context.getString(R.string.channel_normal)
        val title = "$name $normalCount"
        normalCount++
        val description = context.getString(R.string.channel_normal_description)
        val descriptions = "$description + $description + $description + $description"
        val args = Bundle().apply {
            putString(TITLE, title)
            putString(DESCRIPTION, description)
        }
        val pendingIntent = NavDeepLinkBuilder(context).apply {
            setGraph(R.navigation.navigation)
            setDestination(R.id.notificationNormalFragment)
            setArguments(args)
        }.createPendingIntent()
        val notification = NotificationCompat.Builder(context, NORMAL.channel).apply {
            setSmallIcon(DEFAULT_ICON)
            setContentTitle(title)
            setContentText(descriptions)
            priority = PRIORITY_DEFAULT
            setAutoCancel(true)
            setContentIntent(pendingIntent)
        }.build()

        NotificationManagerCompat.from(context).notify(normalCount, notification)
    }

    private var groupCount = 1

    fun notifyGroup() {
        val channel = ChannelType.Group.channel
        val groupKey = GROUP.key
        val name = context.getString(R.string.channel_group)
        val description = context.getString(R.string.channel_group_description)
        val title = "$name $groupCount"
        groupCount++
        val args = Bundle().apply {
            putString(TITLE, title)
            putString(DESCRIPTION, description)
        }
        val intent = NavDeepLinkBuilder(context).apply {
            setGraph(R.navigation.navigation)
            setDestination(R.id.notificationGroupFragment)
            setArguments(args)
        }.createPendingIntent()
        val notification = NotificationCompat.Builder(context, channel).apply {
            setSmallIcon(DEFAULT_ICON)
            setContentTitle(title)
            setContentText(description)
            setStyle(NotificationCompat.BigTextStyle().bigText(description))
            priority = PRIORITY_DEFAULT
            setAutoCancel(true)
            setGroup(groupKey)
            setContentIntent(intent)
        }.build()

        val summaryNotification = NotificationCompat.Builder(context, channel).apply {
            setSmallIcon(R.mipmap.ic_notification)
            setStyle(NotificationCompat.InboxStyle())
            setGroup(groupKey)
            setGroupSummary(true)
        }.build()

        NotificationManagerCompat.from(context).apply {
            notify(groupCount, notification)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                notify(GROUP.id, summaryNotification)
            }
        }
    }
}
