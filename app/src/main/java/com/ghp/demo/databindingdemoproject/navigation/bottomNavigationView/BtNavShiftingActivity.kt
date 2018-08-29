package com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView

import android.os.Bundle
import android.support.design.bottomnavigation.LabelVisibilityMode
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.ghp.demo.databindingdemoproject.R
import kotlinx.android.synthetic.main.activity_bt_nav_shifting.*

class BtNavShiftingActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_test -> {
                message.setText(R.string.title_test)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bt_nav_shifting)
//        navigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED //也可以在xml: app:labelVisibilityMode="labeled"
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
