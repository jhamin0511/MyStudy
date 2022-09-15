package com.github.jhamin0511.mystudy.ui.bottomnavigation.custom

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentCustomBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomFragment : BaseFragment(R.layout.fragment_custom) {
    private lateinit var binding: FragmentCustomBinding

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
        // no-op comment in an unused listener function
    }
}
