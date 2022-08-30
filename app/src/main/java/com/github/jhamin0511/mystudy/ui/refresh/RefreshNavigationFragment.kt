package com.github.jhamin0511.mystudy.ui.refresh

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentRefreshNavigationBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class RefreshNavigationFragment : BaseFragment() {
    private lateinit var binding: FragmentRefreshNavigationBinding
    private val viewModel: RefreshViewModel by activityViewModels()

    override fun getLayoutId() = R.layout.fragment_refresh_navigation

    override fun initValue() {
        Timber.i("viewModel : $viewModel")
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        val hostFragment =
            childFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = hostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(navController)

        setHasOptionsMenu(true)
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.refresh_type, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val type = when (item.itemId) {
            R.id.type_always -> RefreshType.ALWAYS
            R.id.type_di -> RefreshType.DI
            R.id.type_enum -> RefreshType.ENUM
            else -> throw IllegalArgumentException("not support menu.")
        }
        viewModel.changeType(type)

        return true
    }
}
