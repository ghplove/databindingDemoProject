package com.ghp.demo.databindingdemoproject.extension

import android.view.View
import com.jakewharton.rxbinding.view.RxView
import java.util.concurrent.TimeUnit

fun View.addClickAction(action: (view: View) -> Unit) {
    RxView.clicks(this)
            .throttleFirst(1, TimeUnit.SECONDS)
            .subscribe{ action(this) }
}