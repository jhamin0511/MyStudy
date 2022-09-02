package com.github.jhamin0511.mystudy.ui.navigation.deeplink

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentDeeplinkABinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavDeeplinkAFragment : BaseFragment() {
    private lateinit var binding: FragmentDeeplinkABinding
    private val navController by lazy { findNavController() }

    override fun getLayoutId() = R.layout.fragment_deeplink_a

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
        binding.btB.setOnClickListener {
            navController.navigate(R.id.action_navDeeplinkAFragment_to_navDeeplinkBFragment)
        }
        binding.btC.setOnClickListener {
            navController.navigate(R.id.action_navDeeplinkAFragment_to_navDeeplinkCFragment)
        }
    }
}
