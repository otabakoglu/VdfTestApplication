package com.vdf.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vdf.testapplication.databinding.MainActivityBinding
import com.vdf.testapplication.ui.viewpager2.ViewPager2Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = MainActivityBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

/*
        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, ViewPager2Fragment())
            .commit()
*/

    }
}
