package com.ghp.demo.databindingdemoproject.binding.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.ghp.demo.databindingdemoproject.testmodel.BindalbeTestModel
import com.ghp.demo.databindingdemoproject.testmodel.UserModel

/**
 * Lifecycle提供了一个新类叫做ViewModel，[一个负责为UI准备数据的帮助类]。
 *
 * 因为ViewModel的生命周期是和Activity或Fragment分开的，
 * 所以在ViewModel中绝对不能引用任何View对象或者任何引用了Activity的Context的对象。
 * 如果ViewModel中需要Application的Context的话，可以继承AndroidViewModel。
 */
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
        user.get()?.userName = "ghp"
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

    /**
     * 当activity被销毁的时候，
     * Framework会调用ViewModel的onCleared(),
     * 可以在此方法中做资源的清理。
     */
    override fun onCleared() {
        super.onCleared()

    }
}