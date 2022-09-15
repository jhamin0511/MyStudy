package com.github.jhamin0511.mystudy.ui.pass

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.app.common.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.databinding.CommonPassedBinding
import com.github.jhamin0511.mystudy.key.DTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PassedArgsFragment : BaseFragment(R.layout.common_passed) {
    companion object {
        fun startArgument(whiskey: WhiskeyDto): PassedArgsFragment {
            val bundle = Bundle().apply {
                putParcelable(DTO, whiskey)
            }
            return PassedArgsFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var binding: CommonPassedBinding
    private val viewModel: PassedViewModel by viewModels()

    override fun initValue() {
        // no-op comment in an unused listener function
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
