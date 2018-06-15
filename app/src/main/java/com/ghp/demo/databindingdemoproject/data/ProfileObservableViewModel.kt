package com.ghp.demo.databindingdemoproject.data

import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.ghp.demo.databindingdemoproject.util.ObservableViewModel

class ProfileObservableViewModel : ObservableViewModel() {
    val name = ObservableField("test")
    val lastName = ObservableField("test")
    val likes = ObservableInt(0)


}