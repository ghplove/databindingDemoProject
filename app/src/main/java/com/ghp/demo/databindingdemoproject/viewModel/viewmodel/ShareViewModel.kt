package com.ghp.demo.databindingdemoproject.viewModel.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ghp.demo.databindingdemoproject.testmodel.UserModel

class ShareViewModel : ViewModel(){
    var selected: MutableLiveData<UserModel> = MutableLiveData()

}