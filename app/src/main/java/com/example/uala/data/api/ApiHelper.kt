package com.example.uala.data.api


class ApiHelper(private val apiService: ApiService) {

    suspend fun getMealsByName(name : String) = apiService.getMealsByName(name)

    suspend fun getRandomMeal() = apiService.getRandomMeal()




}