package com.github.jhamin0511.sample.navigationflow.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_CANCEL_CURRENT
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDeepLinkBuilder
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.cocktail.CocktailActivity
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentNotificationBinding

private const val CHANNEL_ID = "flow_notification"

class NotificationFragment : BaseFragment(R.layout.fragment_notification) {
    private lateinit var binding: FragmentNotificationBinding

    override fun initValue() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_ID, IMPORTANCE_DEFAULT)
            val manger =
                requireActivity().getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manger.createNotificationChannel(channel)
        }
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.btMakgeolli.setOnClickListener {
            notifyNormal("makgeolli", R.id.btmNavLiqueurFragment)
        }
        binding.btSoju.setOnClickListener {
            notifyNormal("soju", R.id.btmNavLiqueurFragment)
        }
        binding.btBeer.setOnClickListener {
            notifyNormal("beer", R.id.btmNavLiqueurFragment)
        }
        binding.btWhiskey.setOnClickListener {
            notifyNormal("whiskey", R.id.btmNavLiqueurFragment)
        }
        binding.btDetailMakgeolli.setOnClickListener {
            notifyNormal("detail makgeolli", R.id.makgeolliDetailFragment)
        }
        binding.btDetailSoju.setOnClickListener {
            notifyNormal("detail soju", R.id.sojuDetailFragment)
        }
        binding.btDetailBeer.setOnClickListener {
            notifyNormal("detail beer", R.id.beerDetailFragment)
        }
        binding.btDetailWhiskey.setOnClickListener {
            notifyNormal("detail whiskey", R.id.whiskeyDetailFragment)
        }
        binding.btCocktail.setOnClickListener {
            val intent = Intent(requireContext(), CocktailActivity::class.java)
            val flag = FLAG_IMMUTABLE or FLAG_CANCEL_CURRENT
            val pending = PendingIntent.getActivity(requireContext(), 0, intent, flag)
            val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID).apply {
                setSmallIcon(R.mipmap.ic_launcher)
                setContentTitle("cocktail")
                setContentText("cocktail")
                setAutoCancel(true)
                setContentIntent(pending)
            }.build()

            NotificationManagerCompat.from(requireContext())
                .notify(System.currentTimeMillis().toInt(), notification)
        }
    }

    private fun notifyNormal(title: String, destination: Int) {
        val pendingIntent = NavDeepLinkBuilder(requireContext()).apply {
            setGraph(R.navigation.nav_graph)
            setDestination(destination)
        }.createPendingIntent()
        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID).apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle(title)
            setContentText(title)
            setAutoCancel(true)
            setContentIntent(pendingIntent)
        }.build()

        NotificationManagerCompat.from(requireContext())
            .notify(System.currentTimeMillis().toInt(), notification)
    }
}
