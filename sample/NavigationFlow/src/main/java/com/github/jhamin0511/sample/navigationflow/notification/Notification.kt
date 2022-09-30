package com.github.jhamin0511.sample.navigationflow.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.github.jhamin0511.sample.navigationflow.MainActivity
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.cocktail.CocktailActivity

object Notification {
    const val CHANNEL_ID = "flow_notification"
    const val URL = "URL"
    const val SCHEME = "navigationflow"
    const val HOST_BOTTOM = "bottom"
    const val HOST_DETAIL = "detail"
    const val MAKGEOLLI = "makgeolli"
    const val SOJU = "soju"
    const val BEER = "beer"
    const val WHISKEY = "whiskey"

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_ID, IMPORTANCE_DEFAULT)
            val manger =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manger.createNotificationChannel(channel)
        }
    }

    fun createURL(host: String, path: String): String {
        val uri = Uri.Builder().apply {
            scheme(SCHEME)
            authority(host)
            path(path)
        }.build()

        return uri.toString()
    }

    fun notifyNormal(context: Context, url: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            data = Uri.parse(url)
        }
        val flag = PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_CANCEL_CURRENT
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, flag)
        val notification = NotificationCompat.Builder(context, CHANNEL_ID).apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle(url)
            setContentText(url)
            setAutoCancel(true)
            setContentIntent(pendingIntent)
        }.build()

        NotificationManagerCompat.from(context)
            .notify(System.currentTimeMillis().toInt(), notification)
    }

    fun notifyNormal(context: Context, url: String, destination: Int) {
        val bundle = Bundle().apply {
            putString(URL, url)
        }
        val pendingIntent = NavDeepLinkBuilder(context).apply {
            setGraph(R.navigation.nav_graph)
            setDestination(destination)
            setArguments(bundle)
        }.createPendingIntent()
        val notification = NotificationCompat.Builder(context, CHANNEL_ID).apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle(url)
            setContentText(url)
            setAutoCancel(true)
            setContentIntent(pendingIntent)
        }.build()

        NotificationManagerCompat.from(context)
            .notify(System.currentTimeMillis().toInt(), notification)
    }

    fun notifyCocktail(context: Context) {
        val intent = Intent(context, CocktailActivity::class.java)
        val flag = PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_CANCEL_CURRENT
        val pending = PendingIntent.getActivity(context, 0, intent, flag)
        val notification = NotificationCompat.Builder(context, CHANNEL_ID).apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle("cocktail")
            setContentText("cocktail")
            setAutoCancel(true)
            setContentIntent(pending)
        }.build()

        NotificationManagerCompat.from(context)
            .notify(System.currentTimeMillis().toInt(), notification)
    }
}
