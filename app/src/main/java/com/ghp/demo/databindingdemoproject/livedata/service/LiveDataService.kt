package com.ghp.demo.databindingdemoproject.livedata.service

import android.arch.lifecycle.MutableLiveData

class LiveDataService {
    companion object {
        val shared: LiveDataService = LiveDataService()
    }
    var mCurrentName: MutableLiveData<String> = MutableLiveData()
}