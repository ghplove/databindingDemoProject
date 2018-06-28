package com.ghp.demo.databindingdemoproject.binding.ui

import android.databinding.DataBindingUtil
import android.databinding.ObservableInt
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.binding.data.ObservableFieldProfile
import com.ghp.demo.databindingdemoproject.databinding.ActivityObservableFieldBinding

class ObservableFieldActivity : AppCompatActivity() {
    private val observableFieldProfile = ObservableFieldProfile("ObservableFieldTest", "test", ObservableInt(8))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_observable_field)
        val binding: ActivityObservableFieldBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_observable_field)
        binding.user = observableFieldProfile

    }

    fun onClick(view: View) {
        observableFieldProfile.likes.set(observableFieldProfile.likes.get() + 1)
    }
}
