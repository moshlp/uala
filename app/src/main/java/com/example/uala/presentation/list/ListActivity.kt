package com.example.uala.presentation.list

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uala.R
import com.example.uala.databinding.ActivityListBinding
import com.example.uala.domain.ListMealsResponse
import com.example.uala.presentation.detail.DetailActivity
import com.example.uala.presentation.list.adapter.MealsAdapter
import com.example.uala.presentation.list.viewmodel.ListViewModel
import com.example.uala.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private val viewModel by viewModel<ListViewModel>()
    private lateinit var adapter: MealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
    }

    private fun searchMeals(search: String) {
        if (!search.isNullOrEmpty()) {
            viewModel.getMealsByName(search).observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            binding.rvMeals.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                            resource.data?.let { response -> retrieveList(response) }
                        }
                        Status.ERROR -> {
                            binding.rvMeals.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.rvMeals.visibility = View.GONE
                        }
                    }
                }
            })
        }
    }

    private fun retrieveList(meals: ListMealsResponse) {
        adapter.apply {
            setData(meals.meals)
        }
    }

    private fun initViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.rvMeals.layoutManager = LinearLayoutManager(this)
        adapter = MealsAdapter(binding.rvMeals, MealsAdapter.ThumbnailListener {
            var intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("meal", it)
            startActivity(intent)
        })
        binding.rvMeals.addItemDecoration(
            DividerItemDecoration(
                binding.rvMeals.context,
                (binding.rvMeals.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.rvMeals.adapter = adapter
        binding.text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchMeals(s.toString())
            }
        })

    }
}