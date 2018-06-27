package com.ghp.demo.databindingdemoproject.livedata.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.ActivityLiveDataBinding
import com.ghp.demo.databindingdemoproject.extension.addClickAction
import com.ghp.demo.databindingdemoproject.livedata.NameViewModel


class LiveDataActivity : AppCompatActivity() {
    lateinit var mNameViewModel: NameViewModel
    lateinit var binding: ActivityLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_live_data)
        mNameViewModel = ViewModelProviders.of(this).get(NameViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)

        mNameViewModel.mCurrentName!!.observe(this, Observer { name: String? ->
            binding.nameText.text = name ?: ""
        })

        mNameViewModel.mNameListData!!.observe(this, Observer { nameList: List<String>? ->

            nameList?.apply {
                var listStr: String = ""
                for (item in nameList) {
                    listStr = listStr + "\n" + item
                }
                binding.nameListText.text = listStr
            }

        })

        binding.nameBtn.addClickAction {
            mNameViewModel.mCurrentName?.value = "liveData"
        }

        binding.nameListBtn.addClickAction {
            val nameList: MutableList<String> = mutableListOf()
            for (i in 0..9) {
                nameList.add("Jane<$i>")
            }
            mNameViewModel.mNameListData?.value = nameList
        }
    }
}
