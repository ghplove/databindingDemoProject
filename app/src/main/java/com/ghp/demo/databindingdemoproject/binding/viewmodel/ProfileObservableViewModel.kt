package com.ghp.demo.databindingdemoproject.binding.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.ghp.demo.databindingdemoproject.testmodel.BindalbeTestModel
import com.ghp.demo.databindingdemoproject.testmodel.UserModel

class ProfileObservableViewModel : BaseObservableViewModel() {
    val name = ObservableField("viewModelTest")
    val lastName = ObservableField("test")
    val likes = ObservableInt(0)
    val isRed = ObservableBoolean(false)

    val bindalbeTestModel = BindalbeTestModel()

    var user = ObservableField<UserModel>()

    /**
     * ObservableField可以包裹变量非Observable的model
     * model初始化后，更改值，必须要notifyChange刷新UI
     */
    fun onclickObservableFieldUser() {
        user.get().userName = "ghp"
        user.notifyChange()
    }

    fun onClick() {
        likes.set(likes.get() + 1)
    }

    /**
     * 验证LivaData改变
     * binding的数据不会同时更新view
     */
    fun onClickName() {
        name.set("ghp")
    }

    fun onClickBindalbeTest() {
        bindalbeTestModel.testStr = "bindalbeTestModel"
    }

}