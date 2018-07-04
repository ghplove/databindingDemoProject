package com.ghp.demo.databindingdemoproject.testmodel

import android.databinding.BaseObservable
import android.databinding.Bindable

class UserModel {
    var userName: String? = null
    var userAge: Int = 0
    var userAdress: String? = null
}

class BookModel {
    var bookName: String? = null
    var bookDes: String? = null
}

/**
 * 继承BaseObservable
 * set方法notifyPropertyChanged
 * get方法@Bindable
 */
class BindalbeTestModel: BaseObservable() {
    var testStr: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(com.ghp.demo.databindingdemoproject.BR.testStr)
        }
        @Bindable
        get() {
            return field?:""
        }

}