package com.github.jhamin0511.mystudy.ui.paging.user.detail

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentUserDetailBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.PickerDialogShower
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentUserDetailBinding
    private val viewModel: UserDetailViewModel by viewModels()
    private val arg: UserDetailFragmentArgs by navArgs()

    override fun getLayoutId() = R.layout.fragment_user_detail

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
