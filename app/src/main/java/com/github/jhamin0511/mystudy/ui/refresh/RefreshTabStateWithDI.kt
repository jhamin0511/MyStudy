package com.github.jhamin0511.mystudy.ui.refresh

import java.util.concurrent.TimeUnit

sealed class RefreshTabStateWithDI(
    private val internal: Long
) {
    object One : RefreshTabStateWithDI(TimeUnit.MINUTES.toMillis(1))
    object Two : RefreshTabStateWithDI(TimeUnit.MINUTES.toMillis(1))
    object Three : RefreshTabStateWithDI(TimeUnit.MINUTES.toMillis(1))
    object Four : RefreshTabStateWithDI(TimeUnit.MINUTES.toMillis(1))

    private var recodingTime: Long = 0L

    fun isRefresh(): Boolean {
        val currentTime = System.currentTimeMillis()
        val refresh = currentTime > internal + recodingTime

        if (refresh) {
            recodingTime = currentTime
        }

        return refresh
    }

    fun expire() {
        recodingTime = 0L
    }
}
