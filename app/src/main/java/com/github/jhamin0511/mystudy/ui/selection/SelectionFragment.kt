package com.github.jhamin0511.mystudy.ui.selection

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentSelectionBinding
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectionFragment : BaseFragment() {
    private lateinit var binding: FragmentSelectionBinding
    private val viewModel: SelectionViewModel by viewModels()
    private val itemClick = object : FoodItemClickListener {
        override fun onClickImage(resource: Int) {
            val action = SelectionFragmentDirections
                .actionSelectionFragmentToImageDetailFragment(resource)
            findNavController().navigate(action)
        }
    }
    private val adapter = FoodAdapter(itemClick)

    override fun getLayoutId() = R.layout.fragment_selection

    override fun initValue() {
        viewModel.callFoods()
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.adapter = adapter
    }

    override fun initObserve() {
        viewModel.observeItems.observe(
            this,
            EventObserver {
                adapter.addItems(it)
            }
        )
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
