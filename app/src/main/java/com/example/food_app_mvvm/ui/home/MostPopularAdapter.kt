package com.example.food_app_mvvm.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_mvvm.data.pojo.CategoryMeals
import com.example.food_app_mvvm.databinding.ListItemMostPopularBinding

class MostPopularAdapter : RecyclerView.Adapter<MostPopularAdapter.ViewHolder>() {
    private var mealsList = ArrayList<CategoryMeals>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemMostPopularBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(private val binding: ListItemMostPopularBinding) :
        RecyclerView.ViewHolder(binding.root)
}