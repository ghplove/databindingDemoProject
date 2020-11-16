package com.ghp.demo.databindingdemoproject.lifecycles.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.ghp.demo.databindingdemoproject.lifecycles.interfaces.IPresenter

class TestTextView : AppCompatTextView, IPresenter {

    val TAG: String = "绑定生命周期"

    var lifecycle: Lifecycle? = null
    var enable: Boolean = true
    lateinit var buffer: StringBuffer

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        buffer = StringBuffer()
    }

    fun setLifecycleEnable(enable: Boolean) {
        this.enable = enable
        lifecycle?.apply {
            if(currentState.isAtLeast(Lifecycle.State.STARTED)){

            }
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
//        super.onCreate(owner)
        if (enable) {
            buffer.append(System.currentTimeMillis().toString() + "-onCreate\n")
            this.text = buffer
        }
    }

    override fun onResume(owner: LifecycleOwner) {
//        super.onResume(owner)
        if (enable) {
            buffer.append(System.currentTimeMillis().toString() + "-onResume\n")
            this.text = buffer
        }
    }

    override fun onPause(owner: LifecycleOwner) {
//        super.onPause(owner)
        if (enable) {
            buffer.append(System.currentTimeMillis().toString() + "-onPause\n")
            this.text = buffer
        }
    }

}