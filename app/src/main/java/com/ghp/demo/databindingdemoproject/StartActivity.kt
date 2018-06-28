package com.ghp.demo.databindingdemoproject

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ghp.demo.databindingdemoproject.databinding.ActivityStartBinding
import com.ghp.demo.databindingdemoproject.extension.addClickAction
import com.ghp.demo.databindingdemoproject.extension.routeToActivity
import com.ghp.demo.databindingdemoproject.livedata.ui.LiveDataActivity
import com.ghp.demo.databindingdemoproject.binding.ui.MainActivity
import com.ghp.demo.lifecycles.ui.LifeCyclesActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_start)
        val binding: ActivityStartBinding = DataBindingUtil.setContentView(this, R.layout.activity_start)

        binding.goBindingPage.addClickAction {
            routeToActivity(MainActivity::class.java)
        }

        binding.goLifecyclesPage.addClickAction {
            routeToActivity(LifeCyclesActivity::class.java)
        }

        binding.goLivedataPage.addClickAction {
            routeToActivity(LiveDataActivity::class.java)
        }
    }
}
