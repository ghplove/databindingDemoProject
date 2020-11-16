package com.ghp.demo.databindingdemoproject.binding.component

import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.databinding.BindingConversion

object DemoBindingConversion {

    @BindingConversion
    @JvmStatic fun convertColorToDrawable(colorString: String): ColorDrawable? {
        var color = Color.parseColor(colorString)
        return ColorDrawable(color)
    }


}