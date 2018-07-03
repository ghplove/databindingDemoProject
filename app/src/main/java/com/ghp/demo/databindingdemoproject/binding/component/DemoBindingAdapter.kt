package com.ghp.demo.databindingdemoproject.binding.component

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide

object DemoBindingAdapter {
    /**
     * BindingAdapter必须是static类型
     */
    @BindingAdapter("imageUrl", "placeholder")
    @JvmStatic fun loadImageFromUrl(view: ImageView,
                         url: String,
                         drawable: Drawable) {
        Glide.with(view.context)
                .load(url)
                .placeholder(drawable)
                .into(view)
    }

}