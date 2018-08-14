package com.ghp.demo.databindingdemoproject.navigation


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.FragmentMenu2NextBinding
import com.ghp.demo.databindingdemoproject.extension.addClickAction

/**
 * A simple [Fragment] subclass.
 *
 */
class Menu2NextFragment : Fragment() {

    lateinit var binding: FragmentMenu2NextBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu2_next, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var test: String = arguments?.getString("test")?:""
//        var num: Int = arguments?.getInt("num")?:0
        var menu2FragmentArgs: Menu2FragmentArgs = Menu2FragmentArgs.fromBundle(arguments)
        var test: String = menu2FragmentArgs.test
        var num: Int = menu2FragmentArgs.num
        binding.testArgs.text = test + "-" + num

        binding.btnBackMenu1Fragment.addClickAction {
            /**
             * popBackStack() 如果当前的返回栈是空的就会报错，因为栈是空的了
             * 但可以跨级返回
             */
            Navigation.findNavController(view).popBackStack(R.id.menu2_fragment, false)
            Navigation.findNavController(view).navigateUp()
        }
    }


}
