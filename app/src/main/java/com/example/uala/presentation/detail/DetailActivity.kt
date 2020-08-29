package com.example.uala.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.uala.R
import com.example.uala.databinding.ActivityDetailBinding
import com.example.uala.databinding.ActivityListBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()

    }

    private fun initViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }
}