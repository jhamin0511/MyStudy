package com.github.jhamin0511.app.common.application

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.github.jhamin0511.app.common.LIFECYCLE_FLOW_LOG_ENABLE
import timber.log.Timber

class ApplicationLifecycleObserve : LifecycleEventObserver {
    companion object {
        private const val TAG = "Lifecycle_Application"
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(TAG).i("$event()")
        }
    }
}
