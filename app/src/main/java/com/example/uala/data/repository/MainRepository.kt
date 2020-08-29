package com.example.uala.data.repository

import com.example.uala.data.api.ApiHelper


class MainRepository (private val apiHelper: ApiHelper) {

    suspend fun getMealsByName(name : String) = apiHelper.getMealsByName(name)

}


