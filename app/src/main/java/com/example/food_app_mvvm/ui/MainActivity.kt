package com.example.food_app_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food_app_mvvm.R
import com.example.food_app_mvvm.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        init()
        setContentView(binding.root)
    }

    private fun init() {
        val iconArray = arrayOf(
            R.drawable.ic_home,
            R.drawable.ic_favorite,
            R.drawable.ic_category
        )
        val nameArray = arrayOf(
            R.drawable.ic_home,
            R.drawable.ic_favorite,
            R.drawable.ic_category
        )


        val adapter = BottomNavigationBarAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.setIcon(iconArray[position])
        }.attach()
    }

}
