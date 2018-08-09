package com.ghp.demo.databindingdemoproject.binding.ui

import android.content.Context
import android.util.Log
import com.ghp.demo.databindingdemoproject.testmodel.BookModel
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.extension.addClickAction


class RecyclerViewAdapter : BaseViewAdapter {
    constructor(context: Context): super(context)

    override fun getLayoutResID(): Int = R.layout.book_recycle_item

    /**
     * 由于同一个adapter未必只有一种ViewHolder，
     * 可能有好几种View type，所以在onBindViewHolder中，
     * 我们只能获取基类的ViewHolder类型，也就是BindingViewHolder，
     * 所以无法去做具体的set操作，如setEmployee。
     * 这时候就可以使用setVariable接口，然后通过BR来指定variable的name。
     */
    override fun onBindViewHolder(holder: AdapterBindingViewHolder<*>, position: Int) {
        var bookModel: BookModel = mList[position] as BookModel

        holder?.binding?.setVariable(com.ghp.demo.databindingdemoproject.BR.item, bookModel)
        holder?.binding?.executePendingBindings()

        holder?.itemView?.addClickAction {
            Log.i("onItemClickListener", "RecyclerViewAdapter addClickAction")
            mListener?.onItemClick(this, bookModel, position)
        }

    }


}