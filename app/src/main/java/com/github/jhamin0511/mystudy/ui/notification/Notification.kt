package com.github.jhamin0511.mystudy.ui.notification

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.key.DESCRIPTION
import com.github.jhamin0511.mystudy.key.TITLE
import com.github.jhamin0511.mystudy.ui.notification.channel.Channel
import com.github.jhamin0511.mystudy.ui.notification.channel.ChannelGroup
import com.github.jhamin0511.mystudy.ui.notification.group.Group

class Notification(
    private val context: Context
) {

    companion object {
        private const val DEFAULT_ICON = R.mipmap.ic_notification
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ChannelGroup.create(context)
            Channel.create(context)
        }
    }

    private fun defaultBuilder(
        channel: Channel,
        title: String,
        descriptions: String
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, channel.id).apply {
            setSmallIcon(DEFAULT_ICON)
            setContentTitle(title)
            setContentText(descriptions)
            setStyle(NotificationCompat.BigTextStyle().bigText(descriptions))
            setAutoCancel(true)
        }
    }

    private var normalCount = 1

    fun notifyNormal() {
        val name = context.getString(R.string.channel_normal)
        val title = "$name $normalCount"
        normalCount++
        val description = context.getString(R.string.channel_normal_description)
        val args = Bundle().apply {
            putString(TITLE, title)
            putString(DESCRIPTION, description)
        }
        val pendingIntent = NavDeepLinkBuilder(context).apply {
            setGraph(R.navigation.navigation)
            setDestination(R.id.notificationNormalFragment)
            setArguments(args)
        }.createPendingIntent()
        val notification =
            defaultBuilder(Channel.NORMAL, title, description).apply {
                setContentIntent(pendingIntent)
            }.build()

        NotificationManagerCompat.from(context)
            .notify(System.currentTimeMillis().toInt(), notification)
    }

    private var groupCount = 1

    fun notifyGroup() {
        val channel = Channel.Group
        val groupKey = Group.NORMAL.key
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
        val notification = defaultBuilder(channel, title, description).apply {
            setGroup(groupKey)
            setContentIntent(intent)
        }.build()
        val summaryNotification = NotificationCompat.Builder(context, channel.id).apply {
            setSmallIcon(R.mipmap.ic_notification)
            setStyle(NotificationCompat.InboxStyle())
            setGroup(groupKey)
            setGroupSummary(true)
        }.build()

        NotificationManagerCompat.from(context).apply {
            notify(System.currentTimeMillis().toInt(), notification)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                notify(Group.NORMAL.id, summaryNotification)
            }
        }
    }

    private var importanceCount = 1

    fun notifyImportance(channel: Channel) {
        val name = context.getString(channel.nameRes)
        val title = "$name $importanceCount"
        importanceCount++
        val description = context.getString(Channel.getDescription(channel))
        val args = Bundle().apply {
            putString(TITLE, title)
            putString(DESCRIPTION, description)
        }
        val pendingIntent = NavDeepLinkBuilder(context).apply {
            setGraph(R.navigation.navigation)
            setDestination(R.id.notificationImportanceFragment)
            setArguments(args)
        }.createPendingIntent()
        val notification = defaultBuilder(channel, title, description).apply {
            setContentIntent(pendingIntent)
        }.build()

        NotificationManagerCompat.from(context)
            .notify(System.currentTimeMillis().toInt(), notification)
    }
}
