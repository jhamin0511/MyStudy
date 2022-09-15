package com.github.jhamin0511.mystudy.ui.notification

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.app.common.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationResultBinding
import com.github.jhamin0511.mystudy.key.COLOR
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationResultFragment : BaseFragment(R.layout.fragment_notification_result) {
    private lateinit var binding: FragmentNotificationResultBinding
    private val viewModel: NotificationResultViewModel by viewModels()

    override fun initValue() {
        viewModel.initModel(requireArguments())
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel

        val backgroundColor = requireArguments().getInt(COLOR)
        binding.clRoot.setBackgroundColor(backgroundColor)
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
