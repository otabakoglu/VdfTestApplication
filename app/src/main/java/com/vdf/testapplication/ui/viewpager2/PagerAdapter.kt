package com.vdf.testapplication.ui.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){

    var data: LinkedHashMap<String, List<String>> = LinkedHashMap()

    var titles: List<String> = emptyList()

    private lateinit var fragment: PageFragment

    override fun getItemCount(): Int = titles.size
    override fun createFragment(position: Int): Fragment {
        fragment = PageFragment(data[titles[position]])

        return fragment
    }

}