package com.github.jhamin0511.mystudy.ui.bottomnavigation

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentUiuxBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UiUxFragment : BaseFragment() {
    private lateinit var binding: FragmentUiuxBinding

    override fun getLayoutId() = R.layout.fragment_uiux

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
