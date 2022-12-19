package com.example.food_app_mvvm.ui


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.food_app_mvvm.ui.category.CategoryFragment
import com.example.food_app_mvvm.ui.favorite.FavoriteFragment
import com.example.food_app_mvvm.ui.home.HomeFragment

private const val NUM_TABS = 3

class BottomNavigationBarAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            1 -> return FavoriteFragment()
            2 -> return CategoryFragment()
        }
        return HomeFragment()
    }
}