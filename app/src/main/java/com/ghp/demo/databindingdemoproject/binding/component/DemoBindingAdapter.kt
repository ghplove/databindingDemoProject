package com.ghp.demo.databindingdemoproject.binding.component

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
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
        Glide.with(view.context)
                .load(url)
                .placeholder(drawable)
                .into(view)
    }

    @BindingAdapter("imageUrl", "placeholder")
    @JvmStatic
    fun loadImageFromUrl2(view: ImageView,
                         url: String,
                         drawable: Drawable) {
        Glide.with(view.context)
                .load(url)
                .placeholder(drawable)
                .into(view)
    }

    @BindingAdapter("android:background")
    @JvmStatic
    fun backgroundBtm(view: View, drawable: Drawable) {
        var bm: Bitmap = CommonUtils.drawableToBitmap(drawable)
        view.background = BitmapDrawable(CommonUtils.roundCrop(bm))
    }

}
