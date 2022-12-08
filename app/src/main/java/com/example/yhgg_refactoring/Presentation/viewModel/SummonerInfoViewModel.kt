package com.example.yhgg_refactoring.presentation.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yhgg_refactoring.data.Key
import com.example.yhgg_refactoring.data.repository.Repository
import com.example.yhgg_refactoring.data.response.LeagueEntryResponse
import com.example.yhgg_refactoring.data.response.MatchResponse
import com.example.yhgg_refactoring.data.response.ParticipantResponse
import io.reactivex.schedulers.Schedulers

class SummonerInfoViewModel(
    private val repository: Repository
) : ViewModel() {
    //소환사 랭크정보
    private val _summonerLeagueLiveData = MutableLiveData<LeagueEntryResponse>()
    val summonerLeagueLiveData = _summonerLeagueLiveData

    //전적정보
    private val _matchDataLiveData = MutableLiveData<List<ParticipantResponse>>()
    val matchDataLiveData = _matchDataLiveData

    @SuppressLint("CheckResult")
    fun getMatchIdByPuuid(puuid: String, id: String) {
        repository.getMatchIdBypuuid(puuid, 1, 20, Key.API_KEY).doOnSuccess { matchIds ->
            matchIds.map { matchId ->
                repository.getMatchInfoByMatchID(matchId, Key.API_KEY).doOnSuccess {
                    val matchData = it.info.participants.filter { it.summonerName == id }
                    _matchDataLiveData.value = matchData
                }
            }
        }.doOnError { }.ignoreElement().subscribeOn(Schedulers.io()).subscribe()
    }

    @SuppressLint("CheckResult")
    fun searchLeagueEntryByEncryptedSummonerId(id: String) {
        repository.getSummonerEntriesByEncryptedSummonerID(id, Key.API_KEY).doOnSuccess {
            val summoner = it[0]
            _summonerLeagueLiveData.postValue(summoner)
        }.doOnError { }.ignoreElement().subscribeOn(Schedulers.io()).subscribe()
    }
}