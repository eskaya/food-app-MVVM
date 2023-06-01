package com.example.food_app_mvvm.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food_app_mvvm.data.pojo.CategoryList
import com.example.food_app_mvvm.data.pojo.Meal
import com.example.food_app_mvvm.data.pojo.MealList
import com.example.food_app_mvvm.di.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private var randomMealLiveData = MutableLiveData<Meal>()
    private var popularItemsLiveData = MutableLiveData<CategoryList>()

    fun getRandomMeal() {
        RetrofitInstance.api.getRandomMealList().enqueue(object : Callback<MealList> {

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    randomMealLiveData.value = response.body()!!.meals[0]
                } else {
                    Log.d("Data null", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("Api Error", t.message.toString())
            }
        })
    }

    fun getCategory(){
        RetrofitInstance.api.getCategory("Seafood").enqueue(object : Callback<CategoryList>{

            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {
               if(response.body() != null) {
                   //popularItemsLiveData.value = response.body()!!.categories
               }
            }

            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun observeRandomMealLiveData(): LiveData<Meal> {
        //liveData --> just read data
        return randomMealLiveData
    }
}


