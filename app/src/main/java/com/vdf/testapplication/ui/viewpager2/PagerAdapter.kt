package com.vdf.testapplication.ui.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class PagerAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle){

    var data: LinkedHashMap<String, List<String>> = LinkedHashMap()

    var titles: List<String> = emptyList()

    private lateinit var fragment: PageFragment

    override fun getItemCount(): Int = titles.size

    override fun createFragment(position: Int): Fragment {
        fragment = PageFragment(data[titles[position]])

        return fragment
    }

}

fun ViewPager2.findCurrentFragment(fragmentManager: FragmentManager): Fragment? {
    return fragmentManager.findFragmentByTag("f$currentItem")
}