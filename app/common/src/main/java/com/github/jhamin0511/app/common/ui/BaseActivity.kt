package com.github.jhamin0511.app.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.jhamin0511.app.common.LIFECYCLE_FLOW_LOG_ENABLE
import timber.log.Timber

@Suppress("TooManyFunctions")
abstract class BaseActivity : AppCompatActivity() {
    abstract fun initValue()
    abstract fun initView()
    abstract fun initObserve()
    abstract fun initEvent()

    private val tagName = "Lifecycle_${this::class.simpleName}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onCreate()")
        }

        initValue()
        initView()
        initObserve()
        initEvent()
    }

    override fun onStart() {
        super.onStart()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onStart()")
        }
    }

    override fun onRestart() {
        super.onRestart()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onRestart()")
        }
    }

    override fun onResume() {
        super.onResume()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onResume()")
        }
    }

    override fun onPause() {
        super.onPause()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onPause()")
        }
    }

    override fun onStop() {
        super.onStop()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onStop()")
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onDestroy()")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onSaveInstanceState()")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onRestoreInstanceState()")
        }
    }
}
