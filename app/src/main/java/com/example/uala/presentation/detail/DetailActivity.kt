package com.example.uala.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.uala.R
import com.example.uala.databinding.ActivityDetailBinding
import com.example.uala.databinding.ActivityListBinding
import com.example.uala.domain.MealResponse
import com.example.uala.presentation.detail.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var viewModel: DetailViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initViews()

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    private fun initViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val meal = intent.getParcelableExtra("meal") as MealResponse
        if (meal != null){
            Picasso.get()
                .load(meal.strMealThumb)
                .error(R.drawable.ic_baseline_not_interested_24)
                .placeholder(R.drawable.ic_baseline_not_interested_24)
                .into(binding.mealPhoto)
            viewModel?.meal = meal
            binding.viewmodel = viewModel
        }
    }
}