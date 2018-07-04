package com.ghp.demo.databindingdemoproject.binding.ui

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.databinding.ActivityRecyclerViewBinding
import com.ghp.demo.databindingdemoproject.testmodel.BookModel

class RecyclerViewActivity : Activity() {
    var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_recycler_view)
        val binding: ActivityRecyclerViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter(this)
        binding.recyclerView.adapter = recyclerViewAdapter
        recyclerViewAdapter?.addAll(getBook())
        recyclerViewAdapter?.mListener = object : RecyclerViewAdapter.OnItemClickListener{
            override fun onItemClick(bookModel: BookModel) {
                Toast.makeText(this@RecyclerViewActivity, bookModel.bookName, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getBook(): MutableList<BookModel> {
        var bookList: MutableList<BookModel> = mutableListOf()
        for(position in 1..10){
            var bookModel = BookModel()
            bookModel.bookDes = "bookDes${position}"
            bookModel.bookName = "bookName${position}"
            bookList.add(bookModel)
        }
        return bookList
    }
}
