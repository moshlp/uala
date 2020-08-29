package com.example.uala.presentation.detail

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.uala.R
import com.example.uala.databinding.ActivityDetailBinding
import com.example.uala.domain.MealResponse
import com.example.uala.presentation.detail.viewmodel.DetailViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
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
            viewModel?.setIngredients()
            binding.viewmodel = viewModel
            binding.thirdPartyPlayerView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                    val videoId = getVideoId(meal)
                    if (videoId != null) {
                        youTubePlayer.cueVideo(videoId, 0f)
                    }
                }
            })
        }

    }

    private fun getVideoId(meal: MealResponse): String? {
        return meal.strYoutube?.substringAfter("=")
    }
}