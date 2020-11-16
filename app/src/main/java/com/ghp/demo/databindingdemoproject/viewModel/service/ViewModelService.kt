package com.ghp.demo.databindingdemoproject.viewModel.service

import androidx.lifecycle.MutableLiveData
import com.ghp.demo.databindingdemoproject.testmodel.UserModel

class ViewModelService {
    companion object {
        val shared: ViewModelService = ViewModelService()
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