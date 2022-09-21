package com.github.jhamin0511.sample.navigationflow.splash

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment(R.layout.fragment_splash) {
    companion object {
        private const val SPLASH_TIME = 2000L
    }

    private lateinit var binding: FragmentSplashBinding
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
                R.id.action_splashFragment_to_mainFragment
            } else {
                R.id.action_splashFragment_to_loginFragment
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
