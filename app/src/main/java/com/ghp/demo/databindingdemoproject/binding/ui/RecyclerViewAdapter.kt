package com.ghp.demo.databindingdemoproject.binding.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ghp.demo.databindingdemoproject.testmodel.BookModel
import android.view.LayoutInflater
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.extension.addClickAction


class RecyclerViewAdapter : RecyclerView.Adapter<AdapterBindingViewHolder<*>> {
    private val mLayoutInflater: LayoutInflater

    var mBookList: MutableList<BookModel> = mutableListOf()

    var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(bookModel: BookModel)
    }

    constructor(context: Context){
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdapterBindingViewHolder<*> {
//        val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.book_recycle_item, parent, false)
//        val holder = ViewHolder(view)
//        return holder
        var binding: ViewDataBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.book_recycle_item, parent, false)

        return AdapterBindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mBookList.size
    }

    /**
     * 由于同一个adapter未必只有一种ViewHolder，
     * 可能有好几种View type，所以在onBindViewHolder中，
     * 我们只能获取基类的ViewHolder类型，也就是BindingViewHolder，
     * 所以无法去做具体的set操作，如setEmployee。
     * 这时候就可以使用setVariable接口，然后通过BR来指定variable的name。
     */
    override fun onBindViewHolder(holder: AdapterBindingViewHolder<*>?, position: Int) {
        var bookModel = mBookList[position]
//        holder?.bookDes?.text = bookModel.bookDes
//        holder?.bookDes?.text = bookModel.bookDes
        holder?.binding?.setVariable(com.ghp.demo.databindingdemoproject.BR.item, bookModel)
        holder?.binding?.executePendingBindings()
        holder?.itemView?.addClickAction {
            mListener?.onItemClick(bookModel)
        }

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
        notifyDataSetChanged()
    }

}