package com.github.jhamin0511.mystudy.ui.notification

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentNotificationResultBinding
import com.github.jhamin0511.mystudy.key.COLOR
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationResultFragment : BaseFragment() {
    private lateinit var binding: FragmentNotificationResultBinding
    private val viewModel: NotificationResultViewModel by viewModels()

    override fun getLayoutId() = R.layout.fragment_notification_result

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
