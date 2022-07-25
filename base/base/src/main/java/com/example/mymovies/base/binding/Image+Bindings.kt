package com.example.mymovies.base.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.mymovies.base.BuildConfig
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String) {
    Picasso.get().load(BuildConfig.API_IMAGE_BASE_URL + url).into(view)
}