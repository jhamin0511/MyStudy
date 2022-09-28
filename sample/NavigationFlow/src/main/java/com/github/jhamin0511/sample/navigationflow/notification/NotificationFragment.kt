package com.github.jhamin0511.sample.navigationflow.notification

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentNotificationBinding
import com.github.jhamin0511.sample.navigationflow.notification.Notification.BEER
import com.github.jhamin0511.sample.navigationflow.notification.Notification.HOST_BOTTOM
import com.github.jhamin0511.sample.navigationflow.notification.Notification.HOST_DETAIL
import com.github.jhamin0511.sample.navigationflow.notification.Notification.MAKGEOLLI
import com.github.jhamin0511.sample.navigationflow.notification.Notification.SOJU
import com.github.jhamin0511.sample.navigationflow.notification.Notification.WHISKEY

class NotificationFragment : BaseFragment(R.layout.fragment_notification) {
    private lateinit var binding: FragmentNotificationBinding

    override fun initValue() {
        Notification.createChannel(requireContext())
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
            val url = Notification.createURL(host = HOST_BOTTOM, path = MAKGEOLLI)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btSoju.setOnClickListener {
            val url = Notification.createURL(host = HOST_BOTTOM, path = SOJU)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btBeer.setOnClickListener {
            val url = Notification.createURL(host = HOST_BOTTOM, path = BEER)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btWhiskey.setOnClickListener {
            val url = Notification.createURL(host = HOST_BOTTOM, path = WHISKEY)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btDetailMakgeolli.setOnClickListener {
            val url = Notification.createURL(host = HOST_DETAIL, path = MAKGEOLLI)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btDetailSoju.setOnClickListener {
            val url = Notification.createURL(host = HOST_DETAIL, path = SOJU)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btDetailBeer.setOnClickListener {
            val url = Notification.createURL(host = HOST_DETAIL, path = BEER)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btDetailWhiskey.setOnClickListener {
            val url = Notification.createURL(host = HOST_DETAIL, path = WHISKEY)
            Notification.notifyNormal(requireContext(), url)
        }
        binding.btCocktail.setOnClickListener {
            Notification.notifyCocktail(requireContext())
        }
    }
}
