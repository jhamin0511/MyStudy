package com.github.jhamin0511.mystudy.ui.image

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentImageDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentImageDetailBinding
    private val viewModel: ImageDetailViewModel by viewModels()
    private val arg: ImageDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int {
        return R.layout.fragment_image_detail
    }

    override fun initValue() {
        viewModel.initModel(arg)
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
}
