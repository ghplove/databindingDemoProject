package com.ghp.demo.databindingdemoproject.binding.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

//class AdapterBindingViewHolder<T: ViewDataBinding> : RecyclerView.ViewHolder {
//    var mBinding: T
//    constructor(binding: T): super(binding.root){
//        mBinding = binding
//    }
//}

class AdapterBindingViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)