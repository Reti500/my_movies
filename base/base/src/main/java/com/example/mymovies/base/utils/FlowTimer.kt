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
    }
}