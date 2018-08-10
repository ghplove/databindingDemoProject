package com.ghp.demo.databindingdemoproject.viewModel.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.ActivityTestViewModelBinding
import com.ghp.demo.databindingdemoproject.viewModel.viewmodel.ShareViewModel

class TestViewModelActivity : AppCompatActivity() {
    var binding: ActivityTestViewModelBinding? = null
    var viewModel: ShareViewModel? = null
    var test1Fragment: ViewModelTest1Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_view_model)
        viewModel = ViewModelProviders.of(this).get(ShareViewModel::class.java)
        test1Fragment = ViewModelTest1Fragment()
        addFragment(test1Fragment!!)
    }

    fun addFragment(fragment: Fragment){
        supportFragmentManager
                .beginTransaction()
                .add(R.id.framelayout, fragment)
                .commitAllowingStateLoss()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.framelayout, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}
