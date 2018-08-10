package com.ghp.demo.databindingdemoproject.navigation

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.ActivityNavigationMainBinding

class NavigationMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityNavigationMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_navigation_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation_main)
        // Set up ActionBar
        setSupportActionBar(binding.toolbar)

//        var navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.garden_nav_fragment) as NavHostFragment
//        navController = navHostFragment.navController
//        NavigationUI.setupActionBarWithNavController(this, navController)

        navController = Navigation.findNavController(this, R.id.garden_nav_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)

        // Set up navigation menu
        binding?.navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
//       return navController.navigateUp()
        return NavigationUI.navigateUp(binding.drawerLayout, navController)
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
