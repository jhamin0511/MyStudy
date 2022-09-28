package com.github.jhamin0511.mystudy.ui.selection

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.app.common.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentSelectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectionFragment : BaseFragment(R.layout.fragment_selection) {
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
    private val tracker by lazy {
        SelectionTracker.Builder(
            "food",
            binding.recycler,
            StableIdKeyProvider(binding.recycler),
            FoodItemDetailsLookup(binding.recycler),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()
    }

    override fun initValue() {
        viewModel.callFoods()
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.adapter = adapter
        adapter.tracker = tracker
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
