package com.github.jhamin0511.mystudy.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

private const val SHOW_LIFECYCLE_LOGO = false

@Suppress("TooManyFunctions")
abstract class BaseActivity : AppCompatActivity() {
    abstract fun initValue()
    abstract fun initView()
    abstract fun initObserve()
    abstract fun initEvent()

    private val tagName = "Lifecycle_${this::class.simpleName}"

    override fun onCreate(savedInstanceState: Bundle?) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onCreate()")
        }
        super.onCreate(savedInstanceState)

        initValue()
        initView()
        initObserve()
        initEvent()
    }

    override fun onStart() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onStart()")
        }
        super.onStart()
    }

    override fun onRestart() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onRestart()")
        }
        super.onRestart()
    }

    override fun onResume() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onResume()")
        }
        super.onResume()
    }

    override fun onPause() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onPause()")
        }
        super.onPause()
    }

    override fun onStop() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onStop()")
        }
        super.onStop()
    }

    override fun onDestroy() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onDestroy()")
        }
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onSaveInstanceState()")
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onRestoreInstanceState()")
        }
        super.onRestoreInstanceState(savedInstanceState)
    }
}
