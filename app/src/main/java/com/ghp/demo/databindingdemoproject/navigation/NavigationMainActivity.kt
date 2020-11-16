package com.ghp.demo.databindingdemoproject.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
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
//        var navSimple: NavGraph = navHostFragment.navController.navInflater.inflate(R.navigation.nav_garden)
//        var menu2FragDestination: NavDestination = navSimple.findNode(R.id.menu2_fragment)
//        var menu2FragmentArgs: Menu2FragmentArgs = Menu2FragmentArgs.fromBundle(bundleOf("test" to getString(R.string.menu2next_args), "num" to 9))
//        menu2FragDestination.setDefaultArguments(menu2FragmentArgs.toBundle())
//        navHostFragment.navController.graph = navSimple

//        navController = navHostFragment.navController
//        NavigationUI.setupActionBarWithNavController(this, navController)

        navController = Navigation.findNavController(this, R.id.garden_nav_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)

        // Set up navigation menu
        binding?.navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
//       return navController.navigateUp()
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
