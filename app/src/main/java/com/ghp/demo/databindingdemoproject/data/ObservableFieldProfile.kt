package com.ghp.demo.databindingdemoproject.data

import android.databinding.ObservableInt

data class ObservableFieldProfile(
        val name: String,
        val lastName: String,
        val likes: ObservableInt
)