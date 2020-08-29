package com.example.uala.di

import com.example.demogeopagos.data.api.RetrofitBuilder
import com.example.uala.data.api.ApiHelper
import com.example.uala.data.repository.MainRepository
import com.example.uala.presentation.list.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ualaModule = module {
    viewModel { ListViewModel(get()) }


    single {
        MainRepository(get())
    }

    single {
        ApiHelper(get())
    }

    single {
        RetrofitBuilder.apiService
    }

}

val ualaApp = listOf(ualaModule)