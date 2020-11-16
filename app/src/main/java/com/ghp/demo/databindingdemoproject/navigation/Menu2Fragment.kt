package com.ghp.demo.databindingdemoproject.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.FragmentMenu2Binding
import com.ghp.demo.databindingdemoproject.extension.addClickAction

/**
 * A simple [Fragment] subclass.
 *
 */
class Menu2Fragment : Fragment() {
    lateinit var binding: FragmentMenu2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToSecondFragment.addClickAction {
            var bundle: Bundle = bundleOf(
                    "test" to getString(R.string.menu2next_args),
                    "num" to 9
            )
            it.findNavController().navigate(R.id.action_livedata_fragment_to_livedata2_fragment, bundle)

//            var menu2FragmentArgs: Menu2FragmentArgs = Menu2FragmentArgs.Builder(Menu2FragmentArgs.fromBundle(bundle)).build()
//            var menu2FragmentArgs: Menu2FragmentArgs = Menu2FragmentArgs.Builder(
//                    getString(R.string.menu2next_args),
//                    9).build()
//            Navigation.findNavController(view).navigate(R.id.action_livedata_fragment_to_livedata2_fragment)
//            Navigation.findNavController(view).navigate(R.id.action_livedata_fragment_to_livedata2_fragment, bundle)
//            Navigation.findNavController(view).navigate(R.id.action_livedata_fragment_to_livedata2_fragment, menu2FragmentArgs.toBundle())
        }
    }
}
