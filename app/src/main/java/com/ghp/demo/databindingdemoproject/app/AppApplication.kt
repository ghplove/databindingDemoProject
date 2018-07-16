package com.ghp.demo.databindingdemoproject.app

import android.app.Application

class AppApplication: Application() {
    companion object {
        lateinit var instent: AppApplication
    }

    override fun onCreate() {
        super.onCreate()
        instent = this

    }
}