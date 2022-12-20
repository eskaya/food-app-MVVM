package com.example.food_app_mvvm.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.food_app_mvvm.data.pojo.Meal
import com.example.food_app_mvvm.databinding.ActivityDetailBinding
import com.example.food_app_mvvm.utils.Constants
import com.example.food_app_mvvm.viewModels.MealDetailViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: MealDetailViewModel
    private lateinit var mealDetail: Meal
    private lateinit var mealId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this)[MealDetailViewModel::class.java]
        setContentView(binding.root)
        init()

    }

    private fun init() {
        binding.progressBar.visibility = View.VISIBLE
        mealId = intent.getStringExtra(Constants.MEAL_ID).toString()
        viewModel.getMealDetail(mealId)
        observerMealDetail()
    }

    private fun observerMealDetail() {
        viewModel.observerMealDetailList().observe(this) { data ->
            data?.let {
                mealDetail = data
                loadViews(data)
            }
        }
    }

    private fun loadViews(data: Meal) {
        binding.errorGroup.visibility = View.GONE
        binding.coordinatorLayout.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        Glide.with(this@DetailActivity)
            .load(data.strMealThumb)
            .into(binding.ivMeal)
        binding.collapsingToolbarLayout.title = data.strMeal
        binding.tvCategory.text = data.strCategory
        binding.tvLocation.text = data.strArea
        binding.tvDescription.text = data.strInstructions
    }
}