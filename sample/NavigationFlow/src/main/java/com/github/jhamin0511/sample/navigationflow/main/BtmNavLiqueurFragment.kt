package com.github.jhamin0511.sample.navigationflow.main

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.app.common.viewmodel.EventObserver
import com.github.jhamin0511.sample.navigationflow.MainViewModel
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.cocktail.CocktailActivity
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentBtmNavLiqueurBinding
import com.github.jhamin0511.sample.navigationflow.logBackstack
import com.github.jhamin0511.sample.navigationflow.notification.Notification
import com.github.jhamin0511.sample.navigationflow.notification.Notification.BEER
import com.github.jhamin0511.sample.navigationflow.notification.Notification.MAKGEOLLI
import com.github.jhamin0511.sample.navigationflow.notification.Notification.SOJU
import com.github.jhamin0511.sample.navigationflow.notification.Notification.URL
import com.github.jhamin0511.sample.navigationflow.notification.Notification.WHISKEY
import timber.log.Timber

class BtmNavLiqueurFragment : BaseFragment(R.layout.fragment_btm_nav_liqueur) {
    private lateinit var binding: FragmentBtmNavLiqueurBinding
    private val parentViewModel: MainViewModel by activityViewModels()
    private val navController by lazy { findNavController() }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        val hostFragment =
            childFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val bottomNavController = hostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(bottomNavController)

        startNotificationUrl()
    }

    private fun startNotificationUrl() {
        Timber.i("startNotificationUrl()")
        val url = arguments?.getString(URL)
        Timber.i("url : $url")
        if (url != null && url.isNotEmpty()) {
            val uri = Uri.parse(url)
            Timber.i("host : ${uri.host}")
            moveBottomNavMenu(uri)
            if (uri.host == Notification.HOST_DETAIL) {
                navController.navigate(uri)
            }
        }
    }

    private fun moveBottomNavMenu(uri: Uri) {
        Timber.i("moveBottomNavMenu()")
        Timber.i("lastPathSegment : ${uri.lastPathSegment}")
        when (uri.lastPathSegment) {
            MAKGEOLLI -> {
                binding.bottomNavigation.selectedItemId = R.id.makgeolliFragment
            }
            SOJU -> {
                binding.bottomNavigation.selectedItemId = R.id.sojuFragment
            }
            BEER -> {
                binding.bottomNavigation.selectedItemId = R.id.beerFragment
            }
            WHISKEY -> {
                binding.bottomNavigation.selectedItemId = R.id.whiskeyFragment
            }
        }
    }

    override fun initObserve() {
        parentViewModel.observeBottomIndex.observe(
            this,
            EventObserver {
                binding.bottomNavigation.selectedItemId = it
            }
        )
    }

    override fun initEvent() {
        binding.btLiqueur.setOnClickListener {
            navController.navigate(R.id.action_btmNavLiqueurFragment_to_liqueurFragment)
        }
        binding.btCocktail.setOnClickListener {
            CocktailActivity.start(requireActivity())
        }
        binding.btNotification.setOnClickListener {
            navController.navigate(R.id.action_btmNavLiqueurFragment_to_notificationFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController.logBackstack()
    }
}
