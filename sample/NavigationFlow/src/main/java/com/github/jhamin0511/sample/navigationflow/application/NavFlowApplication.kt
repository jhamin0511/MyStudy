package com.github.jhamin0511.sample.navigationflow.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.github.jhamin0511.app.common.application.ApplicationLifecycleObserve
import timber.log.Timber

class NavFlowApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserve())
        Timber.plant(Timber.DebugTree())
    }
}
