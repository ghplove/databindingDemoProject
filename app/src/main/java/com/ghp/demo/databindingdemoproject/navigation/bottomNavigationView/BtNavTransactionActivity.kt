package com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ghp.demo.databindingdemoproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bt_nav_transaction.*

class BtNavTransactionActivity : AppCompatActivity() {

    var homeFragment: HomeFragment? = null
    var notificationsFragment: NotificationsFragment? = null
    var dashboardFragment: DashboardFragment? = null
    var testFragment: DashboardFragment? = null
    var currentFragment: Fragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            0 -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                }
                settingFragment(homeFragment!!)
            }
            1 -> {
                if (notificationsFragment == null) {
                    notificationsFragment = NotificationsFragment()
                }
                settingFragment(notificationsFragment!!)
            }
            2 -> {
                if (dashboardFragment == null) {
                    dashboardFragment = DashboardFragment()
                }
                settingFragment(dashboardFragment!!)
            }
            3 -> {
                if (testFragment == null) {
                    testFragment = DashboardFragment()
                }
                settingFragment(testFragment!!)
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bt_nav_transaction)
        bottomNavigationView.menu.add(0, 0, 0, resources.getString(R.string.title_home)).setIcon(R.drawable.ic_home_black_24dp)
        bottomNavigationView.menu.add(0, 1, 1, resources.getString(R.string.title_dashboard)).setIcon(R.drawable.ic_dashboard_black_24dp)
        bottomNavigationView.menu.add(0, 2, 2, resources.getString(R.string.title_notifications)).setIcon(R.drawable.ic_notifications_black_24dp)
        bottomNavigationView.menu.add(0, 3, 3, resources.getString(R.string.title_test)).setIcon(R.drawable.ic_notifications_black_24dp)

        if (homeFragment == null) {
            homeFragment = HomeFragment()
        }
        fragmentAdd(R.id.fragment, homeFragment!!)
        currentFragment = homeFragment
//        bottomNavigationView.itemIconTintList = null //如果使用的是自己的png图片，需要设置

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    /**
     * menu默认会回收fragment
     * 每次选择其他menu会重新创建Fragment
     * 下面设置避免重新create
     */
    private fun settingFragment(fragment: Fragment) {
        if (currentFragment != fragment) {
            val transaction = supportFragmentManager.beginTransaction()
            if(!fragment.isAdded){
                transaction.hide(currentFragment!!).add(R.id.fragment, fragment).commit()
            } else {
                transaction.hide(currentFragment!!).show(fragment).commit()
            }
            currentFragment = fragment
        }
    }

    fun fragmentAdd(viewId: Int, fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .add(viewId, fragment)
                .commitAllowingStateLoss()
    }
}
