package com.ghp.demo.databindingdemoproject.binding.component

import android.databinding.BindingConversion
import android.graphics.*
import android.graphics.drawable.ColorDrawable

object DemoBindingConversion {

    @BindingConversion
    @JvmStatic fun convertColorToDrawable(colorString: String): ColorDrawable? {
        var color = Color.parseColor(colorString)
        return ColorDrawable(color)
    }


}