package com.example.food_app_mvvm.viewModels

import android.R.id
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food_app_mvvm.data.pojo.Meal
import com.example.food_app_mvvm.data.pojo.MealList
import com.example.food_app_mvvm.utils.Resource
import com.example.food_app_mvvm.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MealDetailViewModel : ViewModel() {

    private var mealDetailLiveData = MutableLiveData<Meal>()

    fun getMealDetail(id: String) {
        RetrofitInstance.api.getMealDetail(id).enqueue(object : Callback<MealList> {
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    mealDetailLiveData.value = response.body()!!.meals[0]

                } else {
                    Log.d("Response error", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("Error!!", t.message.toString())
            }
        })
    }

//    fun getDetail(id: String?): LiveData<Resource<Meal>>? {
//        val myBeanClass: MutableLiveData<Resource<Meal>> = MutableLiveData<Resource<Meal>>()
//       // val apiInterface: ApiInterface = ApiClient().getClient().create(ApiInterface::class.java)
//       // val call: Call<Meal> = apiInterface.getData(id)
//
//        RetrofitInstance.api.getMealDetail(id).enqueue(object : Callback<Meal?> {
//            override fun onResponse(call: Call<Meal?>, response: Response<Meal?>) {
//                if (response.body() != null) {
//                    val body: Meal? = response.body()
//                    myBeanClass.setValue(Resource.success(body))
//                }
//            }
//
//            override fun onFailure(call: Call<Meal?>, t: Throwable) {
//                myBeanClass.setValue(Resource.error(t.message, null))
//            }
//        })
//        return myBeanClass
//    }


    fun observerMealDetailList(): LiveData<Meal> {
        return mealDetailLiveData
    }
}

