package com.github.jhamin0511.mystudy.ui.notification

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {

    companion object {
        fun start(): NotificationFragment {
            return NotificationFragment()
        }
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
        // no-op comment in an unused listener function
    }
}
