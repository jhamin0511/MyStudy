package com.github.jhamin0511.sample.navigationflow

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.ui.BaseActivity
import com.github.jhamin0511.sample.navigationflow.databinding.ActivityNavFlowABinding

class NavFlowAActivity : BaseActivity() {
    companion object {
        fun start(context: Context): Intent {
            return Intent(context, NavFlowAActivity::class.java)
        }
    }

    private lateinit var binding: ActivityNavFlowABinding

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_flow_a)
        binding.lifecycleOwner = this
    }

    override fun initEvent() {
//        binding.btStartActionA.setOnClickListener {
//            try {
//                val options = NavOptions.Builder()
//                    .setPopUpTo(R.id.navFlowRootFragment, inclusive = true, saveState = false)
//                    .build()
//                val controller = NavHostController(this)
//                controller.setGraph(R.navigation.nav_flow)
//                controller.navigate(R.id.navFlowAFragment, null, options)
//            } catch (e: RuntimeException) {
//                e.printStackTrace()
//                showToast(e.toString())
//            }
//        }
//        binding.btStartDeeplinkA.setOnClickListener {
//            try {
//                val options = NavOptions.Builder()
//                    .setPopUpTo(R.id.navFlowRootFragment, inclusive = true, saveState = false)
//                    .build()
//                val controller = NavHostController(this)
//                controller.setGraph(R.navigation.nav_flow)
//                controller.navigate(Uri.parse("mystudy://a"), options)
//            } catch (e: RuntimeException) {
//                e.printStackTrace()
//                showToast(e.toString())
//            }
//        }
        binding.btStartNewActivity.setOnClickListener {
            val intent = NavFlowActivity.start(this, NavFlowActivity.ACTION_FLOW_A)
            startActivity(intent)
            finish()
        }
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }
}
