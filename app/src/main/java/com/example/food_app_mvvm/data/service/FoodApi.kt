package com.example.food_app_mvvm.data.service

import com.example.food_app_mvvm.data.pojo.CategoryList
import com.example.food_app_mvvm.data.pojo.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("random.php")
    fun getRandomMealList(): Call<MealList>

    @GET("lookup.php?")
    fun getMealDetail(@Query("i") id: String?): Call<MealList>

    @GET("filter.php?")
    fun getCategory(@Query("c") categoryName: String): Call<CategoryList>
}
