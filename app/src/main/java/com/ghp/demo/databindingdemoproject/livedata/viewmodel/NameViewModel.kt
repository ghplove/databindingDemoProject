package com.ghp.demo.databindingdemoproject.livedata.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.ghp.demo.databindingdemoproject.testmodel.UserModel
import java.util.*

class NameViewModel : ViewModel() {

    var mLiveDataTest = MutableLiveData<String>()
    init {
        mLiveDataTest.value = "test"
    }

    var mNameLiveData: MutableLiveData<List<String>>? = null
        set(value) {
            field = value
        }
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }

    var userNameLiveData: MutableLiveData<String> ? = null
        set(value) {
            field = value
        }
        get() {
            if(field == null) {
                field = MutableLiveData()
            }
            return  field
        }

    fun getUserLiveData(): MutableLiveData<UserModel> {
        var userModel: UserModel = UserModel()
        userModel.userName = "ghp"
        userModel.userAge = 27
        userModel.userAdress = "盈亏中心"
        var userLiveData: MutableLiveData<UserModel> = MutableLiveData()
        userLiveData.value = userModel
        return userLiveData
    }

    fun onClick() {
        val random = Random()
        val str = random.nextInt(100).toString() + ""
        Log.i("test", str)
        mLiveDataTest.value = str
    }

}