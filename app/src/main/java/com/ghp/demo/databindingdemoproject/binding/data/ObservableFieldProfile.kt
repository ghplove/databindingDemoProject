package com.ghp.demo.databindingdemoproject.binding.data

import android.databinding.ObservableField
import android.databinding.ObservableInt

data class ObservableFieldProfile(
        val name: String,
        val lastName: String,
        val likes: ObservableInt,
        var userPhotoUrl: ObservableField<String>
)