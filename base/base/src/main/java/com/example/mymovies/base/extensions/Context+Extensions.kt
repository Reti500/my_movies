package com.example.mymovies.base.extensions

import android.app.Activity
import android.content.Intent

fun Activity.navigateToActivity(
    clazz: Class<*>,
    clear: Boolean = false
) {
    val intent = Intent(this, clazz)

    if (clear) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP
        finish()
    }

    startActivity(intent)
}