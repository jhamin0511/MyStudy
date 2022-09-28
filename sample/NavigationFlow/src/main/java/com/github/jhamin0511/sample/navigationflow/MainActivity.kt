package com.github.jhamin0511.sample.navigationflow

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.jhamin0511.app.common.ui.BaseActivity
import com.github.jhamin0511.sample.navigationflow.application.isLogin
import com.github.jhamin0511.sample.navigationflow.databinding.ActivityMainBinding
import com.github.jhamin0511.sample.navigationflow.notification.Notification.BEER
import com.github.jhamin0511.sample.navigationflow.notification.Notification.HOST_DETAIL
import com.github.jhamin0511.sample.navigationflow.notification.Notification.MAKGEOLLI
import com.github.jhamin0511.sample.navigationflow.notification.Notification.SOJU
import com.github.jhamin0511.sample.navigationflow.notification.Notification.WHISKEY
import timber.log.Timber

class MainActivity : BaseActivity() {
    companion object {
        const val ACTION_LOGIN = "com.github.jhamin0511.sample.navigationflow.LOGIN"

        fun startLogin(context: Activity, action: String) {
            val intent = Intent(context, MainActivity::class.java).apply {
                this.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                this.action = action
            }
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    Timber.i("onPreDraw()")
                    if (!isLogin) {
                        navController.setGraph(R.navigation.nav_session)
                    } else {
                        Timber.i("intent : $intent")
                        Timber.i("data : ${intent.data}")
                        Timber.i("host : ${intent.data?.host}")
                        Timber.i("lastPathSegment : ${intent.data?.lastPathSegment}")
                        if (intent.data != null && intent.data?.host == HOST_DETAIL) {
                            when (intent.data?.lastPathSegment) {
                                MAKGEOLLI -> {
                                    navController.navigate(R.id.makgeolliDetailFragment)
                                }
                                SOJU -> {
                                    navController.navigate(R.id.sojuDetailFragment)
                                }
                                BEER -> {
                                    navController.navigate(R.id.beerDetailFragment)
                                }
                                WHISKEY -> {
                                    navController.navigate(R.id.whiskeyDetailFragment)
                                }
                            }
                        }
                        viewModel.bottomNavigationIndex(intent.data?.lastPathSegment)
                    }
                    content.viewTreeObserver.removeOnPreDrawListener(this)

                    return true
                }
            }
        )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Timber.i("onNewIntent : $intent")
        if (intent?.action == ACTION_LOGIN) {
            navController.setGraph(R.navigation.nav_session)
        }
    }
}
