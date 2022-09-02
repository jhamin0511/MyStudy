package com.github.jhamin0511.mystudy.ui.bindingleack

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentBindingTwoBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import com.github.jhamin0511.mystudy.util.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class BindingTwoStayFragment : BaseFragment() {
    private var binding by autoCleared<FragmentBindingTwoBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("BackStackSize : ${findNavController().backQueue.size}")
    }

    override fun getLayoutId() = R.layout.fragment_binding_two

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
        binding.btStart.setOnClickListener {
            findNavController()
                .navigate(R.id.action_bindingTwoStayFragment_to_bindingOneStayFragment)
        }
    }
}
