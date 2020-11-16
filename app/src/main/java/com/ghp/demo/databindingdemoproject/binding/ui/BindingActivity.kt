package com.ghp.demo.databindingdemoproject.binding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.ActivityBindingBinding
import com.ghp.demo.databindingdemoproject.extension.addClickAction
import com.tools.ghp.library.routeToActivity

class BindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_binding)

        val binding: ActivityBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding)

        binding.observableFieldsActivityButton.addClickAction {
            routeToActivity(ObservableFieldActivity::class.java)
        }

        binding.viewmodelActivityButton.addClickAction {
            routeToActivity(ViewModelActivity::class.java)
        }

        binding.recyclerViewActivityButton.addClickAction {
            routeToActivity(RecyclerViewActivity::class.java)
        }
    }
}
