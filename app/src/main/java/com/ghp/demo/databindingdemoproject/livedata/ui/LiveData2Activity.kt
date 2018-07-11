package com.ghp.demo.databindingdemoproject.livedata.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.ActivityLiveData2Binding
import com.ghp.demo.databindingdemoproject.extension.addClickAction
import com.ghp.demo.databindingdemoproject.livedata.service.LiveDataService
import com.ghp.demo.databindingdemoproject.livedata.viewmodel.NameViewModel

class LiveData2Activity : AppCompatActivity() {

    lateinit var mNameViewModel: NameViewModel
    lateinit var binding: ActivityLiveData2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNameViewModel = ViewModelProviders.of(this).get(NameViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data2)

        LiveDataService.shared.mCurrentName.observe(this, Observer { name: String? ->
            binding.nameText.text = name ?: ""
        })

        binding.nameBtn.addClickAction {
            LiveDataService.shared.mCurrentName?.value = "liveData2"
        }

    }
}
