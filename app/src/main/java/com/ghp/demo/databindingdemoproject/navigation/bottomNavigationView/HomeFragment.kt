package com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ghp.demo.databindingdemoproject.R

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.i("navigation: ","onCreateView HomeFragment")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}
