package com.github.jhamin0511.mystudy.ui.refresh

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentRefreshBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RefreshFragment : BaseFragment() {
    private lateinit var binding: FragmentRefreshBinding

    override fun getLayoutId() = R.layout.fragment_refresh

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
        binding.btAlways.setOnClickListener {
            findNavController().navigate(R.id.action_refreshFragment_to_refreshNavigationFragment)
        }
    }
}
