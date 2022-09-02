package com.github.jhamin0511.mystudy.ui.navigation.deeplink

import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ActivityNavDeeplinkBinding
import com.github.jhamin0511.mystudy.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavDeeplinkActivity : BaseActivity() {
    private lateinit var binding: ActivityNavDeeplinkBinding

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_deeplink)
        binding.lifecycleOwner = this
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }
}
