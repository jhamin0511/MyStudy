package com.github.jhamin0511.mystudy.ui.diffutil.detail

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentWhiskeyDetailBinding
import com.github.jhamin0511.mystudy.key.DTO
import com.github.jhamin0511.mystudy.key.REQUEST
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.PickerDialogShower
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WhiskeyDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentWhiskeyDetailBinding
    private val viewModel: WhiskeyDetailViewModel by viewModels()
    private val arg: WhiskeyDetailFragmentArgs by navArgs()

    override fun getLayoutId(): Int {
        return R.layout.fragment_whiskey_detail
    }

    override fun initValue() {
        viewModel.initModel(arg)
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel

        setHasOptionsMenu(true)
    }

    override fun initObserve() {
        viewModel.observeSaved.observe(this, EventObserver {
            setFragmentResult(REQUEST, bundleOf(DTO to it))
            findNavController().popBackStack()
        })
        viewModel.observeShowPicker.observe(this, EventObserver {
            PickerDialogShower.showDateTime(requireContext(), it) { time ->
                viewModel.applyDate(time)
            }
        })
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save -> {
                viewModel.save()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
