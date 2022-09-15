package com.github.jhamin0511.mystudy.ui.navigation.flow

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentFlowSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NavFlowSplashFragment : BaseFragment( R.layout.fragment_flow_splash) {
    companion object {
        private const val SPLASH_TIME = 2000L
    }

    private lateinit var binding: FragmentFlowSplashBinding
    private val navController by lazy { findNavController() }
    private val isLogin = false

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        lifecycleScope.launch {
            delay(SPLASH_TIME)

            val actionId = if (isLogin) {
                R.id.action_navFlowSplashFragment_to_navFlowMainFragment
            } else {
                R.id.action_navFlowSplashFragment_to_navFlowLoginFragment
            }
            navController.navigate(actionId)
        }
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
