package com.example.mymovies.base.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration

class FlowTimer {
    companion object {
        fun tickerFlow(period: Duration) = flow {
            while (true) {
                emit(Unit)
                delay(period)
            }
        }

        fun countDown(duration: Long, interval: Long = 1000) = flow {
            var initial = duration
            while (initial >= 0) {
                emit(initial)
                delay(interval)
                initial -= 1
            }
        }
    }
}