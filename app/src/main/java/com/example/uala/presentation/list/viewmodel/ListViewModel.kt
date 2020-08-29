package com.example.uala.presentation.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.uala.data.repository.MainRepository
import com.example.uala.utils.Resource
import kotlinx.coroutines.Dispatchers

class ListViewModel  (private val mainRepository: MainRepository)  : ViewModel() {

    fun getMealsByName(name:String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getMealsByName(name)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}