package com.github.jhamin0511.mystudy.ui.refresh

import java.util.concurrent.TimeUnit

enum class RefreshTabStateWithEnum(
    private val internal: Long
) {
    One(TimeUnit.MINUTES.toMillis(1)),
    Two(TimeUnit.MINUTES.toMillis(1)),
    Three(TimeUnit.MINUTES.toMillis(1)),
    Fore(TimeUnit.MINUTES.toMillis(1));

    private var recodingTime: Long = 0

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
