package com.example.food_app_mvvm.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.food_app_mvvm.data.pojo.Meal
import com.example.food_app_mvvm.data.pojo.MealList
import com.example.food_app_mvvm.databinding.FragmentHomeBinding
import com.example.food_app_mvvm.ui.MainActivity
import com.example.food_app_mvvm.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RetrofitInstance.api.getRandomMealList().enqueue(object : Callback<MealList> {
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    val randomMeal: Meal = response.body()!!.meals[0]
                    Glide.with(requireActivity() as MainActivity)
                        .load(randomMeal.strMealThumb)
                        .into(binding.ivHealthyLifeStyle)
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                t.message?.let { Log.d("error", it) }
            }
        })
    }
}