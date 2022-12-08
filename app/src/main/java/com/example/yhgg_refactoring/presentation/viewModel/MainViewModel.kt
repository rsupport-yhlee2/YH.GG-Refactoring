package com.example.yhgg_refactoring.presentation.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yhgg_refactoring.data.Key
import com.example.yhgg_refactoring.data.repository.Repository
import com.example.yhgg_refactoring.data.response.SummonerResponse
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _summonerLiveData: MutableLiveData<SummonerResponse> = MutableLiveData()
    val summonerLiveData = _summonerLiveData

    @SuppressLint("CheckResult")
    fun search(summonerName: String) {
        Log.e("search", summonerName)
        val singleSummoner = repository.getSummonerInfoByName(summonerName, Key.API_KEY)

        singleSummoner.doOnSuccess {
            summonerLiveData.postValue(it)
        }.doOnError {
            Log.e("error", it.message.toString())
        }.ignoreElement().subscribeOn(Schedulers.io()).subscribe()
    }
}