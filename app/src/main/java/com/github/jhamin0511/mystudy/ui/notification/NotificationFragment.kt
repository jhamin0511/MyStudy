package com.github.jhamin0511.mystudy.ui.notification

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationBinding
import com.github.jhamin0511.mystudy.ui.notification.channel.Channel
import com.github.jhamin0511.mystudy.ui.notification.style.Style
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment() {
    private lateinit var binding: FragmentNotificationBinding
    private val notification: Notification by lazy {
        Notification(requireContext())
    }

    override fun getLayoutId() = R.layout.fragment_notification

    override fun bindValue() {
        // no-op comment in an unused listener function
    }

    override fun bindView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
    }

    override fun bindObserve() {
        // no-op comment in an unused listener function
    }

    override fun bindEvent() {
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
