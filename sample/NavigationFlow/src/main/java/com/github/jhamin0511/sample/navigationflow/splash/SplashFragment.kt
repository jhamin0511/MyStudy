package com.github.jhamin0511.sample.navigationflow.splash

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.application.isLogin
import com.github.jhamin0511.sample.navigationflow.application.isShowSplash
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment(R.layout.fragment_splash) {
    companion object {
        private const val SPLASH_TIME = 2000L
    }

    private lateinit var binding: FragmentSplashBinding
    private val navController by lazy { findNavController() }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this


        if (!isShowSplash) {
            lifecycleScope.launch {
                delay(SPLASH_TIME)

                startMainAndSession()
                isLogin = true
            }
            isShowSplash = true
        } else {
            startMainAndSession()
        }
    }

    private fun startMainAndSession() {
        if (isLogin) {
            navController.navigate(R.id.action_splashFragment_to_btmNavLiqueurFragment)
        } else {
            navController.setGraph(R.navigation.nav_session)
        }
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
