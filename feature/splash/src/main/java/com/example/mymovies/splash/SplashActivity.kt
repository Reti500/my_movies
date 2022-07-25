package com.example.mymovies.splash

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.mymovies.base.extensions.navigateToActivity
import com.example.mymovies.base.utils.FlowTimer
import com.example.mymovies.movies.MoviesActivity
import com.example.mymovies.splash.constants.Constants
import com.example.mymovies.splash.databinding.ActivitySplashBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FlowTimer.countDown(Constants.SPLASH_DURATION)
            .onEach { if (it == 0L) { goToMoviesActivity() } }
            .launchIn(lifecycleScope)

        Log.e("Splash", "Aqui")
    }

    private fun goToMoviesActivity() {
        navigateToActivity(MoviesActivity::class.java, true)
    }
}