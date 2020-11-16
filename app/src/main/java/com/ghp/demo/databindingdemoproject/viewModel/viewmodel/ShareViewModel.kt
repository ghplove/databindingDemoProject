package com.ghp.demo.databindingdemoproject.viewModel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ghp.demo.databindingdemoproject.testmodel.UserModel

class ShareViewModel : ViewModel(){
    var selected: MutableLiveData<UserModel> = MutableLiveData()

}