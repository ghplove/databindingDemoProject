package com.ghp.demo.databindingdemoproject.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.ghp.demo.databindingdemoproject.R


/**
 * A simple [Fragment] subclass.
 *
 */
class Menu1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu1, container, false)
    }


}
