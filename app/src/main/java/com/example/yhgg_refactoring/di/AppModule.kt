package com.example.yhgg_refactoring.di

import com.example.yhgg_refactoring.data.DataProvider
import com.example.yhgg_refactoring.data.repository.APIRepository
import com.example.yhgg_refactoring.data.repository.Repository
import com.example.yhgg_refactoring.presentation.viewModel.MainViewModel
import com.example.yhgg_refactoring.presentation.viewModel.SummonerInfoViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal val AppModule = module {
    single { Dispatchers.Main }

    //firebase
    single { DataProvider.provideFirebase() }
    single { DataProvider.provideReference(get()) }

    //retrofit
    single { DataProvider.buildOkHttpClient() }
    single { DataProvider.provideCenterRetrofit(get()) }
    single { DataProvider.provideCenterAPIService(get()) }

    //repository
    single<Repository> { APIRepository(get()) }

    //viewModel
    single { MainViewModel(get()) }
    single { SummonerInfoViewModel(get()) }
}