package com.ghp.demo.databindingdemoproject.binding.component

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ghp.demo.databindingdemoproject.utils.CommonUtils

object DemoBindingAdapter {
    /**
     * BindingAdapter必须是static类型
     * requireAll 默认是true
     */
    @BindingAdapter("imageUrl", "placeholder")
    @JvmStatic
    fun loadImageFromUrl(view: ImageView,
                         url: String,
                         drawable: Drawable) {
        var requestOptions: RequestOptions= RequestOptions()
                .placeholder(drawable)
        Glide.with(view.context)
                .load(url)
                .apply(requestOptions)
//                .placeholder(drawable)
                .into(view)
    }

    @BindingAdapter("imageUrl", "placeholder")
    @JvmStatic
    fun loadImageFromUrl2(view: ImageView,
                         url: String,
                         drawable: Drawable) {
        var requestOptions: RequestOptions= RequestOptions()
                .placeholder(drawable)
        Glide.with(view.context)
                .load(url)
                .apply(requestOptions)
//                .placeholder(drawable)
                .into(view)
    }

}
