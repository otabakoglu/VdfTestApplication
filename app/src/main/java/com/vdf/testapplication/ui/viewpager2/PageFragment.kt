package com.vdf.testapplication.ui.viewpager2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.vdf.testapplication.R
import com.vdf.testapplication.databinding.FragmentRecyclerviewBinding

class PageFragment(
    var data: List<String>? =  List(2){"xxxxxxx$it"}
) :
    Fragment(R.layout.fragment_recyclerview) {

    private lateinit var viewBinding: FragmentRecyclerviewBinding
    lateinit var adapter: RecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecyclerViewAdapter()
        adapter.submitList(data)

        viewBinding = FragmentRecyclerviewBinding.bind(view)
        viewBinding.apply {
            textView.text = data?.size.toString()
            recyclerView.adapter = adapter
        }

    }

    fun refresh(mData: List<String>?){
        adapter.submitList(mData)
        adapter.notifyDataSetChanged()
    }


}