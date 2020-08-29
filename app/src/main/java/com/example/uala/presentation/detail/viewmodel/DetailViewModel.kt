package com.example.uala.presentation.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.uala.domain.MealResponse

class DetailViewModel  : ViewModel() {

    var meal : MealResponse? = null

    fun setIngredients() {
        val separator = System.getProperty("line.separator")
        val builder = StringBuilder()
        if (meal?.strIngredient1?.isNotEmpty()!!){
            builder.append(meal?.strIngredient1 + separator)
        }
        if (meal?.strIngredient2?.isNotEmpty()!!){
            builder.append(meal?.strIngredient2 + separator)
        }
        if (meal?.strIngredient3?.isNotEmpty()!!){
            builder.append(meal?.strIngredient3 + separator)
        }
        if (meal?.strIngredient4?.isNotEmpty()!!){
            builder.append(meal?.strIngredient4 + separator)
        }
        if (meal?.strIngredient5?.isNotEmpty()!!){
            builder.append(meal?.strIngredient5 + separator)
        }
        if (meal?.strIngredient6?.isNotEmpty()!!){
            builder.append(meal?.strIngredient6 + separator)
        }
        if (meal?.strIngredient7?.isNotEmpty()!!){
            builder.append(meal?.strIngredient7 + separator)
        }
        if (meal?.strIngredient8?.isNotEmpty()!!){
            builder.append(meal?.strIngredient8 + separator)
        }
        if (meal?.strIngredient9?.isNotEmpty()!!){
            builder.append(meal?.strIngredient9 + separator)
        }
        if (meal?.strIngredient10?.isNotEmpty()!!){
            builder.append(meal?.strIngredient10 + separator)
        }
        if (meal?.strIngredient11?.isNotEmpty()!!){
            builder.append(meal?.strIngredient11 + separator)
        }
        if (meal?.strIngredient12?.isNotEmpty()!!){
            builder.append(meal?.strIngredient12 + separator)
        }
        if (meal?.strIngredient13?.isNotEmpty()!!){
            builder.append(meal?.strIngredient13 + separator)
        }
        if (meal?.strIngredient14?.isNotEmpty()!!){
            builder.append(meal?.strIngredient14 + separator)
        }
        if (meal?.strIngredient15?.isNotEmpty()!!){
            builder.append(meal?.strIngredient15 + separator)
        }
        if (meal?.strIngredient16?.isNotEmpty()!!){
            builder.append(meal?.strIngredient16 + separator)
        }
        if (meal?.strIngredient17?.isNotEmpty()!!){
            builder.append(meal?.strIngredient17 + separator)
        }
        if (meal?.strIngredient18?.isNotEmpty()!!){
            builder.append(meal?.strIngredient18 + separator)
        }
        if (meal?.strIngredient19?.isNotEmpty()!!){
            builder.append(meal?.strIngredient19 + separator)
        }
        if (meal?.strIngredient20?.isNotEmpty()!!){
            builder.append(meal?.strIngredient20 + separator)
        }
        if (builder.isNotEmpty()){
            meal?.ingredients = builder.toString()
        }
    }



}