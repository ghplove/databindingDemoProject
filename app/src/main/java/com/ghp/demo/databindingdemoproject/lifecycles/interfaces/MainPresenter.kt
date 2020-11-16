package com.ghp.demo.databindingdemoproject.lifecycles.interfaces

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner

class MainPresenter : IPresenter {
    val TAG = "MainPresenter"

    constructor(context: Context)

    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG,  "onCreate: ")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG,  "onStart: ")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG,  "onResume: ")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG,  "onPause: ")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG,  "onDestroy: ")
    }
}