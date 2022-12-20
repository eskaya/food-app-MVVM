package com.example.food_app_mvvm.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.food_app_mvvm.databinding.FragmentHomeBinding
import com.example.food_app_mvvm.ui.MainActivity
import com.example.food_app_mvvm.ui.detail.DetailActivity
import com.example.food_app_mvvm.viewModels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        listeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getRandomMeal()
        observerRandomMeal()
    }

    private fun listeners() {
        binding.ivRandomMeal.setOnClickListener {
            val intent = Intent((requireContext() as MainActivity), DetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observerRandomMeal() {
        viewModel.observeRandomMealLiveData().observe(viewLifecycleOwner) { data ->
            data.let {
                Glide.with(this@HomeFragment)
                    .load(data.strMealThumb)
                    .into(binding.ivRandomMeal)
            }
        }
    }
}