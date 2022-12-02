package com.example.yhgg_refactoring.data.repository

import com.example.yhgg_refactoring.data.response.LeagueEntryResponse
import com.example.yhgg_refactoring.data.response.LeagueListResponse
import com.example.yhgg_refactoring.data.response.MatchResponse
import com.example.yhgg_refactoring.data.response.SummonerResponse
import io.reactivex.Single

interface Repository {
    fun getSummonerInfoByName(
        SummonerName: String,
        APIKey: String
    ): Single<SummonerResponse>

    fun getSummonerEntriesByEncryptedSummonerID(
        encryptedSummonerId : String,
        APIKey : String
    ): Single<List<LeagueEntryResponse>>

    fun getLeagueByGivenID(
        leagueID : String,
        APIKey : String
    ): Single<LeagueListResponse>

    fun getMatchIdBypuuid(
        puuid :String,
         start : Int,
        count : Int,
        APIKey : String,
    ): Single<List<String>>

    fun getMatchInfoByMatchID(
        MatchId: String,
        APIKey : String
    ): Single<MatchResponse>
}