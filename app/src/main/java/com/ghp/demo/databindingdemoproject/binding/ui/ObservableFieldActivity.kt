package com.ghp.demo.databindingdemoproject.binding.ui

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.databinding.OnRebindCallback
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.binding.data.ObservableFieldProfile
import com.ghp.demo.databindingdemoproject.databinding.ActivityObservableFieldBinding

class ObservableFieldActivity : AppCompatActivity() {
    val observableFieldProfile = ObservableFieldProfile("ObservableFieldTest", "test", ObservableInt(8), ObservableField("https://avatars2.githubusercontent.com/u/1106500?v=3&s=460"))

    var binding: ActivityObservableFieldBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_observable_field)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observable_field)
        binding?.user = observableFieldProfile
        binding?.presenter = Presenter()

        binding?.addOnRebindCallback(object : OnRebindCallback<ActivityObservableFieldBinding>(){
            override fun onPreBind(binding: ActivityObservableFieldBinding?): Boolean {
                val view = binding?.root as ViewGroup
                TransitionManager.beginDelayedTransition(view)
                return true
            }
        })
    }

    inner class Presenter {
        fun onClick(view: View) {
            observableFieldProfile.likes.set(observableFieldProfile.likes.get() + 1)
        }

        fun onCheckChanged(buttonView: View, isChecked: Boolean) {
            binding?.showImage = isChecked
        }

        fun onChangeImgUrl(buttonView: View) {
            observableFieldProfile.userPhotoUrl.set("https://avatars2.githubusercontent.com/u")
        }
        fun onChangeImgNullUrl(buttonView: View) {
            observableFieldProfile.userPhotoUrl.set("")
        }

    }
}
