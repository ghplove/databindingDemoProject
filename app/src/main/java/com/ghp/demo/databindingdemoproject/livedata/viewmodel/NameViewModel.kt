package com.ghp.demo.databindingdemoproject.livedata.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    var mCurrentName: MutableLiveData<String>? = null
        set(value) {
            field = value
        }
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }

    var mNameListData: MutableLiveData<List<String>>? = null
        set(value) {
            field = value
        }
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }

}