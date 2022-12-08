package com.example.yhgg_refactoring.Presentation.Adapter

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

object BindingAdapter {

    @androidx.databinding.BindingAdapter("level")
    @JvmStatic
    fun setLevel(view: TextView, level: Long) {
        view.text = level.toString()
    }

    @androidx.databinding.BindingAdapter("ImageURL")
    @JvmStatic
    fun setImage(view: ImageView, url: String) {
        Glide.with(view)
            .load(url)
            .into(view)
    }
}