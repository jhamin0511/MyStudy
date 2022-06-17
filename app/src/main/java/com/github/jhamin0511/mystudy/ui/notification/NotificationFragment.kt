package com.github.jhamin0511.mystudy.ui.notification

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    private val notification: Notification by lazy {
        Notification(requireContext())
    }

    override fun getLayoutId() = R.layout.fragment_notification

    override fun bindValue() {
        // no-op comment in an unused listener function
    }

    override fun bindView() {
        // no-op comment in an unused listener function
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
    }
}
