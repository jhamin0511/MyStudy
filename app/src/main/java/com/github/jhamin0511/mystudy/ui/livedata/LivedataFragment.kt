package com.github.jhamin0511.mystudy.ui.livedata

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.app.common.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentLivedataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LivedataFragment : BaseFragment(R.layout.fragment_livedata) {
    private lateinit var binding: FragmentLivedataBinding
    private val viewModel: LivedataViewModel by viewModels()

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    override fun initObserve() {
        viewModel.observeStartExtract.observe(
            this,
            EventObserver {
                val action =
                    LivedataFragmentDirections.actionLivedataFragmentToLivedataExtractFragment(it)
                findNavController().navigate(action)
            }
        )
        viewModel.observeStartObject.observe(
            this,
            EventObserver {
                val action =
                    LivedataFragmentDirections.actionLivedataFragmentToLivedataObjectFragment(
                        it.id,
                        it
                    )
                findNavController().navigate(action)
            }
        )
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
