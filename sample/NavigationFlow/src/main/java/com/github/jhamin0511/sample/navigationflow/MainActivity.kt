package com.github.jhamin0511.sample.navigationflow

import android.app.Activity
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.jhamin0511.app.common.ui.BaseActivity
import com.github.jhamin0511.sample.navigationflow.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : BaseActivity() {
    companion object {
        const val ACTION_LOGIN = "com.github.jhamin0511.sample.navigationflow.LOGIN"

        fun startLogin(context: Activity, action: String) {
            val intent = Intent(context, MainActivity::class.java).apply {
                this.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                this.action = action
            }
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy { findNavController(R.id.fragment_container) }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Timber.i("intent : $intent")
        if (intent?.action == ACTION_LOGIN) {
            navController.setGraph(R.navigation.nav_session)
        } else {
            navController.handleDeepLink(intent)
        }
    }
}
