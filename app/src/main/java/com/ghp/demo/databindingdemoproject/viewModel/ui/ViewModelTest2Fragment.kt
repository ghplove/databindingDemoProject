package com.ghp.demo.databindingdemoproject.viewModel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.FragmentViewmodelTest2Binding
import com.ghp.demo.databindingdemoproject.extension.addClickAction
import com.ghp.demo.databindingdemoproject.testmodel.UserModel
import com.ghp.demo.databindingdemoproject.viewModel.viewmodel.ShareViewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewModelTest2Fragment : Fragment() {

    var binding: FragmentViewmodelTest2Binding? = null
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_viewmodel_test2, container, false)
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
