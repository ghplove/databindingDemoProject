package com.ghp.demo.databindingdemoproject.binding.data

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt


data class ObservableFieldProfile(
        val name: String,
        val lastName: String,
        val likes: ObservableInt,
        var userPhotoUrl: ObservableField<String>
)