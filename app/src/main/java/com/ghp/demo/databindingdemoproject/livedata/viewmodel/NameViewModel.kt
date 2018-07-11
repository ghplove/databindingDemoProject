package com.ghp.demo.databindingdemoproject.livedata.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ghp.demo.databindingdemoproject.testmodel.UserModel

class NameViewModel : ViewModel() {

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


}