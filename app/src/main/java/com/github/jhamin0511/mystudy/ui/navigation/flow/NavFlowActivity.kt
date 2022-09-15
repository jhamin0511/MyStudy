package com.github.jhamin0511.mystudy.ui.navigation.flow

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ActivityNavFlowBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class NavFlowActivity : com.github.jhamin0511.app.common.BaseActivity() {
    companion object {
        const val ACTION_FLOW_A = "navigation.flow.NavFlowAFragment"

        fun start(context: Context, action: String): Intent {
            val flags = Intent.FLAG_ACTIVITY_NO_ANIMATION or
                Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK

            return Intent(context, NavFlowActivity::class.java).apply {
                this.flags = flags
                this.action = action
            }
        }
    }

    private lateinit var binding: ActivityNavFlowBinding
//    private val navController by lazy { findNavController(R.id.fragment_deeplink_container) }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_flow)
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
//        if (intent?.action == ACTION_FLOW_A) {
//            val options = NavOptions.Builder()
//                .setPopUpTo(R.id.navFlowRootFragment, inclusive = true, saveState = false)
//                .build()
//            navController.navigate(R.id.navFlowAFragment, null, options)
//        } else {
//            navController.handleDeepLink(intent)
//        }
    }

    override fun onPause() {
        super.onPause()

        overridePendingTransition(0, R.anim.activity_stay)
    }
}
