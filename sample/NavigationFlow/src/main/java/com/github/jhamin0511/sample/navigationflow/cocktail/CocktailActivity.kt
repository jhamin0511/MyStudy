package com.github.jhamin0511.sample.navigationflow.cocktail

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.github.jhamin0511.app.common.extension.showToast
import com.github.jhamin0511.app.common.ui.BaseActivity
import com.github.jhamin0511.sample.navigationflow.MainActivity
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.ActivityCocktailBinding

class CocktailActivity : BaseActivity() {
    companion object {
        fun start(context: Activity) {
            val intent = Intent(context, CocktailActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityCocktailBinding

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cocktail)
        binding.lifecycleOwner = this
    }

    override fun initEvent() {
        @Suppress("TooGenericExceptionCaught")
        binding.btStartActionLogin.setOnClickListener {
            try {
                val controller = NavHostController(this)
                controller.setGraph(R.navigation.nav_session)
            } catch (e: RuntimeException) {
                e.printStackTrace()
                showToast(e.toString())
            }
        }
        @Suppress("TooGenericExceptionCaught")
        binding.btStartDeeplinkLogin.setOnClickListener {
            try {
                val options = NavOptions.Builder()
                    .build()
                val controller = NavHostController(this)
                controller.setGraph(R.navigation.nav_session)
                controller.navigate(Uri.parse("bottomnavigation://login"), options)
            } catch (e: RuntimeException) {
                e.printStackTrace()
                showToast(e.toString())
            }
        }
        binding.btStartNewActivity.setOnClickListener {
            MainActivity.startLogin(this, MainActivity.ACTION_LOGIN)
        }
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }
}
