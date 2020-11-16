package com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.ghp.demo.databindingdemoproject.R

/**
 * A simple [Fragment] subclass.
 *
 */
class DashboardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.i("navigation: ","onCreateView DashboardFragment")
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }


}
