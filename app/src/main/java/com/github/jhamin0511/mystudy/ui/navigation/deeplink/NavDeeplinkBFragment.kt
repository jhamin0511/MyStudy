package com.github.jhamin0511.mystudy.ui.navigation.deeplink

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentDeeplinkBBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavDeeplinkBFragment : BaseFragment() {
    private lateinit var binding: FragmentDeeplinkBBinding
    private val navController by lazy { findNavController() }

    override fun getLayoutId() = R.layout.fragment_deeplink_b

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
        binding.btC.setOnClickListener {
            navController.navigate(R.id.action_navDeeplinkBFragment_to_navDeeplinkCFragment)
        }
    }
}