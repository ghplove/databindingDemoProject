package com.ghp.demo.databindingdemoproject.lifecycles.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.ActivityLifeCyclesBinding
import com.ghp.demo.databindingdemoproject.lifecycles.interfaces.IPresenter
import com.ghp.demo.databindingdemoproject.lifecycles.interfaces.MainPresenter

class LifeCyclesActivity : AppCompatActivity() {
    val TAG = "LifeCyclesActivity"

    lateinit var mPresenter: IPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_life_cycles)
        val binding: ActivityLifeCyclesBinding = DataBindingUtil.setContentView(this, R.layout.activity_life_cycles)
        mPresenter = MainPresenter(this)
        lifecycle.addObserver(mPresenter)

        binding.testTextview.lifecycle = lifecycle


        lifecycle.addObserver(binding.testTextview)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}
