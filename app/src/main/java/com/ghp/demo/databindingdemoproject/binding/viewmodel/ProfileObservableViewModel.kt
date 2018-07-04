package com.ghp.demo.databindingdemoproject.binding.viewmodel

import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.ghp.demo.databindingdemoproject.testmodel.BindalbeTestModel

class ProfileObservableViewModel : BaseObservableViewModel() {
    val name = ObservableField("viewModelTest")
    val lastName = ObservableField("test")
    val likes = ObservableInt(0)

    val bindalbeTestModel = BindalbeTestModel()

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