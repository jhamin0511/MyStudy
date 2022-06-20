package com.github.jhamin0511.mystudy.ui.notification

import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationResultBinding
import com.github.jhamin0511.mystudy.key.COLOR
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationResultFragment : BaseFragment<FragmentNotificationResultBinding>() {

    private val viewModel: NotificationResultViewModel by viewModels()

    override fun getLayoutId() = R.layout.fragment_notification_result

    override fun bindValue() {
        viewModel.initModel(requireArguments())
    }

    override fun bindView() {
        binding.vm = viewModel

        val backgroundColor = requireArguments().getInt(COLOR)
        binding.clRoot.setBackgroundColor(backgroundColor)
    }

    override fun bindObserve() {
        // no-op comment in an unused listener function
    }

    override fun bindEvent() {
        // no-op comment in an unused listener function
    }
}