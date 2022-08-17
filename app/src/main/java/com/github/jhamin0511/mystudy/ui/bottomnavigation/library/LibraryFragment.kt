package com.github.jhamin0511.mystudy.ui.bottomnavigation.library

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentLibraryBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : BaseFragment() {
    private lateinit var binding: FragmentLibraryBinding

    override fun getLayoutId() = R.layout.fragment_library

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
