package com.github.jhamin0511.mystudy.ui.notification

import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationResultBinding

class NotificationNormalFragment : BaseFragment<FragmentNotificationResultBinding>() {

    private val viewModel: NotificationResultViewModel by viewModels()

    override fun getLayoutId() = R.layout.fragment_notification_result

    override fun bindValue() {
        viewModel.initModel(requireArguments())
    }

    override fun bindView() {
        binding.vm = viewModel
        binding.clRoot.setBackgroundColor(R.color.purple_50)
    }

    override fun bindObserve() {
        // no-op comment in an unused listener function
    }

    override fun bindEvent() {
        // no-op comment in an unused listener function
    }
}
