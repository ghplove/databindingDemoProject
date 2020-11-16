package com.ghp.demo.databindingdemoproject.binding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.binding.viewmodel.ProfileObservableViewModel
import com.ghp.demo.databindingdemoproject.databinding.ActivityViewModelBinding
import com.ghp.demo.databindingdemoproject.testmodel.UserModel

class ViewModelActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_model)

        val viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel::class.java)

        val binding: ActivityViewModelBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        binding.viewModel = viewModel

        viewModel.user.set(UserModel())
    }
}
