package com.ghp.demo.databindingdemoproject.binding.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ghp.demo.databindingdemoproject.testmodel.BookModel
import android.widget.TextView
import android.view.LayoutInflater
import com.ghp.demo.databindingdemoproject.R


class RecyclerBaseAdapter : RecyclerView.Adapter<BindingViewHolder<*>> {
    private val mLayoutInflater: LayoutInflater

    var mBookList: MutableList<BookModel> = mutableListOf()

    constructor(context: Context){
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BindingViewHolder<*> {
//        val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.book_recycle_item, parent, false)
//        val holder = ViewHolder(view)
//        return holder
        var binding: ViewDataBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.book_recycle_item, parent, false)

        return BindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mBookList.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>?, position: Int) {
        var bookModel = mBookList[position]
//        holder?.bookDes?.text = bookModel.bookDes
//        holder?.bookDes?.text = bookModel.bookDes
        holder?.binding?.setVariable(com.ghp.demo.databindingdemoproject.BR.item, bookModel)
        holder?.binding?.executePendingBindings()

    }

//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var bookDes: TextView? = null
//        var bookname: TextView? = null
//
//        init {
//            bookDes = view.findViewById<View>(R.id.book_des) as TextView
//            bookname = view.findViewById<View>(R.id.book_name) as TextView
//        }
//    }


    fun addAll(mBookList: MutableList<BookModel>){
        this.mBookList.clear()
        this.mBookList.addAll(mBookList)
    }

}