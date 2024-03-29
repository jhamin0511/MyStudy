package com.github.jhamin0511.mystudy.ui.notification

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationBinding
import com.github.jhamin0511.mystudy.ui.notification.channel.Channel
import com.github.jhamin0511.mystudy.ui.notification.style.Style
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment(R.layout.fragment_notification) {
    private lateinit var binding: FragmentNotificationBinding
    private val notification: Notification by lazy {
        Notification(requireContext())
    }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.createNormal.setOnClickListener {
            notification.notifyNormal()
        }
        binding.createGroup.setOnClickListener {
            notification.notifyGroup()
        }
        binding.createHigh.setOnClickListener {
            notification.notifyImportance(Channel.HIGH)
        }
        binding.createDefault.setOnClickListener {
            notification.notifyImportance(Channel.DEFAULT)
        }
        binding.createLow.setOnClickListener {
            notification.notifyImportance(Channel.LOW)
        }
        binding.createMin.setOnClickListener {
            notification.notifyImportance(Channel.MIN)
        }
        binding.createPicture.setOnClickListener {
            notification.notifyStyle(Style.BIG_PICTURE)
        }
        binding.createText.setOnClickListener {
            notification.notifyStyle(Style.BIG_TEXT)
        }
        binding.createMessaging.setOnClickListener {
            notification.notifyStyle(Style.MESSAGING)
        }
        binding.createInbox.setOnClickListener {
            notification.notifyStyle(Style.INBOX)
        }
    }
}
