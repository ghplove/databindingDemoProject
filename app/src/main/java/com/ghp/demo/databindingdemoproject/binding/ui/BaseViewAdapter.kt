package com.ghp.demo.databindingdemoproject.binding.ui

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseViewAdapter: RecyclerView.Adapter<AdapterBindingViewHolder<*>> {
    val mContext: Context
    val mLayoutInflater: LayoutInflater
    var mListener: OnItemClickListener? = null

    var mList: MutableList<Any> = mutableListOf()
    abstract fun getLayoutResID(): Int

    constructor(context: Context){
        mContext = context
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBindingViewHolder<*> {
        var binding: ViewDataBinding = DataBindingUtil.inflate(mLayoutInflater, getLayoutResID(), parent, false)

        return AdapterBindingViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return mList.size
    }


//    companion object {
//        @BindingAdapter("android:onItemClick")
//        @JvmStatic
//        fun setUpAdapter(recyclerView: RecyclerView, onItemClickListener: OnItemClickListener) {
//            var adapter: BaseViewAdapter = (recyclerView.adapter ?: return) as? BaseViewAdapter ?: return
//            Log.i("onItemClickListener", "BindingAdapter setUpAdapter")
//            adapter.mListener = object : OnItemClickListener{
//                override fun onItemClick(adapter: BaseViewAdapter, model: Any, position: Int) {
//                    Log.i("onItemClickListener", "BindingAdapter onItemClick")
//                    onItemClickListener.onItemClick(adapter, model, position)
//                }
//            }
//        }
//    }

    interface OnItemClickListener {
        fun onItemClick(adapter: BaseViewAdapter, model: kotlin.Any, position: Int)
    }

    fun addAll(mList: MutableList<Any>){
        this.mList.clear()
        this.mList.addAll(mList)
        notifyDataSetChanged()
    }
}