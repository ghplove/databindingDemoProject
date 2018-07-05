package com.ghp.demo.databindingdemoproject.utils

import android.graphics.*
import android.graphics.Bitmap
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable



object CommonUtils {

    fun roundCrop(source: Bitmap?): Bitmap? {
        if (source == null) return null
        //返回一个正好匹配给定宽、高和配置的只包含透明像素的Bitmap
        // 如果BitmapPool中找不到这样的Bitmap，就返回null
//        var result: Bitmap? = pool.get(source.width, source.height, Bitmap.Config.ARGB_8888)
        //当返回null 时,创建给定宽、高和配置的新位图
//        if (result == null) {
        var result: Bitmap = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
//        }

        val canvas = Canvas(result)
        val paint = Paint()
        // 设置shader
        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        //抗锯齿
        paint.isAntiAlias = true
        //画矩形
        val rectF = RectF(0f, 0f, source.width.toFloat(), source.height.toFloat())
        //绘制圆角矩形   (RectF对象,x方向上的圆角半径,y方向上的圆角半径,绘制时所使用的画笔)
        val radius = 20f
        canvas.drawRoundRect(rectF, radius, radius, paint)
        return result
    }

    fun drawableToBitmap(drawable: Drawable): Bitmap {
        // 取 drawable 的长宽
        val w = drawable.intrinsicWidth
        val h = drawable.intrinsicHeight

        // 取 drawable 的颜色格式
        val config = if (drawable.opacity != PixelFormat.OPAQUE)
            Bitmap.Config.ARGB_8888
        else
            Bitmap.Config.RGB_565
        // 建立对应 bitmap
        val bitmap = Bitmap.createBitmap(w, h, config)
        // 建立对应 bitmap 的画布
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, w, h)
        // 把 drawable 内容画到画布中
        drawable.draw(canvas)
        return bitmap
    }


}