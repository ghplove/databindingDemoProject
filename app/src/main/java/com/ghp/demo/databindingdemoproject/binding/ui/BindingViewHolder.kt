package com.ghp.demo.databindingdemoproject.binding.ui

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

//class BindingViewHolder<T: ViewDataBinding> : RecyclerView.ViewHolder {
//    var mBinding: T
//    constructor(binding: T): super(binding.root){
//        mBinding = binding
//    }
//}

class BindingViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)