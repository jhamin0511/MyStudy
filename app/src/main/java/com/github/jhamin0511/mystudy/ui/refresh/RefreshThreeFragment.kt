package com.github.jhamin0511.mystudy.ui.refresh

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentRefreshThreeBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class RefreshThreeFragment : BaseFragment() {
    private lateinit var binding: FragmentRefreshThreeBinding
    private val viewModel: RefreshViewModel by activityViewModels()

    override fun getLayoutId() = R.layout.fragment_refresh_three

    override fun initValue() {
        // no-op comment in an unused listener function
        Timber.i("viewModel : $viewModel")
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun onResume() {
        super.onResume()

        viewModel.applyRefresh(RefreshPosition.THREE)
    }
}