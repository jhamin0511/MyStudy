package com.github.jhamin0511.mystudy.ui.bindingleack

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentBindingLeakBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BindingLeakFragment : BaseFragment() {
    private lateinit var binding: FragmentBindingLeakBinding

    override fun getLayoutId() = R.layout.fragment_binding_leak

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
        binding.btStayMemory.setOnClickListener {
            findNavController().navigate(R.id.action_bindingLeakFragment_to_bindingOneStayFragment)
        }
        binding.btClearMemory.setOnClickListener {
            findNavController().navigate(R.id.action_bindingLeakFragment_to_bindingOneClearFragment)
        }
    }
}
