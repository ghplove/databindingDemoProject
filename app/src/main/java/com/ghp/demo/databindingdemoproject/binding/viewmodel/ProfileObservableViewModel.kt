package com.ghp.demo.databindingdemoproject.binding.viewmodel

import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.ghp.demo.databindingdemoproject.binding.viewmodel.ObservableViewModel

class ProfileObservableViewModel : ObservableViewModel() {
    val name = ObservableField("viewModelTest")
    val lastName = ObservableField("test")
    val likes = ObservableInt(0)

    fun onClick() {
        likes.set(likes.get() + 1)
    }
}