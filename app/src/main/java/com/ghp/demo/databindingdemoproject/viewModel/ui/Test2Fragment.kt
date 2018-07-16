package com.ghp.demo.databindingdemoproject.viewModel.ui


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.FragmentTest2Binding
import com.ghp.demo.databindingdemoproject.extension.addClickAction
import com.ghp.demo.databindingdemoproject.testmodel.UserModel
import com.ghp.demo.databindingdemoproject.viewModel.viewmodel.ShareViewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class Test2Fragment : Fragment() {

    var binding: FragmentTest2Binding? = null
    var model: ShareViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.let {
            ViewModelProviders.of(it).get(ShareViewModel::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test2, container, false)
        binding?.testViewmodelSharedataBtn?.addClickAction {
            var user: UserModel = model?.selected?.value?: UserModel()
            user.userName = "viewModelTest"
            model?.selected?.value = user
        }
        model?.selected?.observe(this, Observer{ user ->
            binding?.testTextview?.text = user?.userName
        })

        return binding?.root
    }

}
