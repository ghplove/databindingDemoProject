package com.ghp.demo.databindingdemoproject

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ghp.demo.databindingdemoproject.databinding.ActivityStartBinding
import com.ghp.demo.databindingdemoproject.extension.addClickAction
import com.ghp.demo.databindingdemoproject.livedata.ui.LiveDataActivity
import com.ghp.demo.databindingdemoproject.binding.ui.BindingActivity
import com.ghp.demo.databindingdemoproject.lifecycles.ui.LifeCyclesActivity
import com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView.BottomNavigationActivity
import com.ghp.demo.databindingdemoproject.navigation.NavigationMainActivity
import com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView.BtNavShiftingActivity
import com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView.BtNavTransactionActivity
import com.ghp.demo.databindingdemoproject.viewModel.ui.TestViewModelActivity
import com.tools.ghp.library.routeToActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_start)
        val binding: ActivityStartBinding = DataBindingUtil.setContentView(this, R.layout.activity_start)

        binding.goBindingPage.addClickAction {
            routeToActivity(BindingActivity::class.java)
        }

        binding.goLifecyclesPage.addClickAction {
            routeToActivity(LifeCyclesActivity::class.java)
        }

        binding.goLivedataPage.addClickAction {
            routeToActivity(LiveDataActivity::class.java)
        }

        binding.goTestViewModelPage.addClickAction {
            routeToActivity(TestViewModelActivity::class.java)
        }

        binding.goTestNavigationPage.addClickAction {
            routeToActivity(NavigationMainActivity::class.java)
        }
        binding.goBottomNavigationPage.addClickAction {
            routeToActivity(BottomNavigationActivity::class.java)
        }
        go_BtNavShifting_page.addClickAction {
            routeToActivity(BtNavShiftingActivity::class.java)
        }
        go_BtNavTransaction_page.addClickAction {
            routeToActivity(BtNavTransactionActivity::class.java)
        }
    }
}
