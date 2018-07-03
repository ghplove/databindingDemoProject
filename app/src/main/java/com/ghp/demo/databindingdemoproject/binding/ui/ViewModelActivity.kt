package com.ghp.demo.databindingdemoproject.binding.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.ghp.demo.databindingdemoproject.R
import com.ghp.demo.databindingdemoproject.binding.viewmodel.ProfileObservableViewModel
import com.ghp.demo.databindingdemoproject.databinding.ActivityViewModelBinding
import com.ghp.demo.databindingdemoproject.testmodel.BookModel

class ViewModelActivity : AppCompatActivity() {

    var recyclerBaseAdapter: RecyclerBaseAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_model)

        val viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel::class.java)

        val binding: ActivityViewModelBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        binding.viewModel = viewModel

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerBaseAdapter = RecyclerBaseAdapter(this)
        binding.recyclerView.adapter = recyclerBaseAdapter
        recyclerBaseAdapter?.addAll(getBook())
        recyclerBaseAdapter?.mListener = object : RecyclerBaseAdapter.OnItemClickListener{
            override fun onItemClick(bookModel: BookModel) {
                Toast.makeText(this@ViewModelActivity, bookModel.bookName, Toast.LENGTH_SHORT).show()
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
