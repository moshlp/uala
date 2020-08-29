package com.example.uala.data.api

import com.example.uala.domain.ListMealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
    suspend fun getMealsByName(@Query("s") name : String): ListMealsResponse
}