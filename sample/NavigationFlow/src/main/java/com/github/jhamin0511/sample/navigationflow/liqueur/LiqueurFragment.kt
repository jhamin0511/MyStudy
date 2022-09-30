package com.github.jhamin0511.sample.navigationflow.liqueur

import android.net.Uri
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.application.isLogin
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentLiqueurBinding

class LiqueurFragment : BaseFragment(R.layout.fragment_liqueur) {
    private lateinit var binding: FragmentLiqueurBinding
    private val navController: NavController by lazy { findNavController() }

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
        binding.btDeeplinkMakgeolli.setOnClickListener {
            val deepLink = Uri.parse("navigationflow://detail/makgeolli")
            navController.navigate(deepLink, null)
        }
        binding.btDeeplinkSoju.setOnClickListener {
            val deepLink = Uri.parse("navigationflow://detail/soju")
            navController.navigate(deepLink, null)
        }
        binding.btDeeplinkBeer.setOnClickListener {
            val deepLink = Uri.parse("navigationflow://detail/beer")
            navController.navigate(deepLink, null)
        }
        binding.btDeeplinkWhiskey.setOnClickListener {
            val deepLink = Uri.parse("navigationflow://detail/whiskey")
            navController.navigate(deepLink, null)
        }
        binding.btGlobalActionMakgeolli.setOnClickListener {
            navController.navigate(R.id.action_global_makgeolliDetailFragment)
        }
        binding.btGlobalActionSoju.setOnClickListener {
            navController.navigate(R.id.action_global_sojuDetailFragment)
        }
        binding.btGlobalActionBeer.setOnClickListener {
            navController.navigate(R.id.action_global_beerDetailFragment)
        }
        binding.btGlobalActionWhiskey.setOnClickListener {
            navController.navigate(R.id.action_global_whiskeyDetailFragment)
        }
        binding.btStartSession.setOnClickListener {
            isLogin = false
            navController.navigate(R.id.loginFragment)
        }
    }
}
