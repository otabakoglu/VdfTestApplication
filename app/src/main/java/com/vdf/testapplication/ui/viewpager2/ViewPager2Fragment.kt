package com.vdf.testapplication.ui.viewpager2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.viewpager2.widget.ViewPager2
import com.vdf.testapplication.R
import com.vdf.testapplication.databinding.FragmentViewpager2Binding
import java.util.*

typealias StringList = List<String>

class ViewPager2Fragment : Fragment(R.layout.fragment_viewpager2) {

    private lateinit var viewBinding: FragmentViewpager2Binding
    private lateinit var adapter: PagerAdapter

    private val data: LinkedHashMap<String, List<String>> = linkedMapOf(
        "page 1" to List(13){ "list item $it" },
        "page 2" to List(5){ "list item $it" }
    )

    private var titles: StringList = data.keys.toList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PagerAdapter(childFragmentManager, object : Lifecycle(){
            override fun addObserver(observer: LifecycleObserver) {
            }

            override fun removeObserver(observer: LifecycleObserver) {
            }

            override fun getCurrentState(): State {
                return State.CREATED
            }
        })
        adapter.data = data
        adapter.titles = titles

        viewBinding = FragmentViewpager2Binding.bind(view)

        viewBinding.apply {
            viewPager2.adapter = adapter
            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.i("onPageSelected", position.toString())

                    //adapter.refresh(data["page 0"])
                }
            })

            buttonAdd.setOnClickListener {
                addPage()
            }

            buttonDelete.setOnClickListener {
                removePage()
            }

            buttonChange.setOnClickListener{
                changePage()
            }

            textViewCount.text = adapter.data.size.toString()
        }
    }

    private fun changePage() {
        val x = List(Random().nextInt(6) + 4){"list item $it"}
        (viewBinding.viewPager2.findCurrentFragment(childFragmentManager) as? PageFragment)?.refresh(x)
    }

    private fun addPage(){
        data["page ${data.size + 1}"] = List(Random().nextInt(6) + 4){"list item $it"}
        adapter.data = data

        titles = data.keys.toList()
        adapter.titles = titles

        adapter.notifyDataSetChanged()

        viewBinding.textViewCount.text = adapter.data.size.toString()
    }

    private fun removePage(){
        if(titles.isEmpty()) return

        data.remove(titles.last())
        adapter.data = data

        titles = data.keys.toList()
        adapter.titles = titles

        adapter.notifyDataSetChanged()

        viewBinding.textViewCount.text = adapter.data.size.toString()
    }

}