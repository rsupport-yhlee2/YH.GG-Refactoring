package com.example.yhgg_refactoring.data.repository

import com.example.yhgg_refactoring.data.DataProvider
import com.example.yhgg_refactoring.data.response.LeagueEntryResponse
import com.example.yhgg_refactoring.data.response.LeagueListResponse
import com.example.yhgg_refactoring.data.response.MatchResponse
import com.example.yhgg_refactoring.data.response.SummonerResponse
import io.reactivex.Single
import yunho.app.lolapitest.lolAPI.lolAPIService

class APIRepository(
    private val apiService: lolAPIService,
) : Repository {
    private val match = DataProvider.provideMatchRetrofit(DataProvider.buildOkHttpClient())
    private val matchService = match.create(lolAPIService::class.java)
    override fun getSummonerInfoByName(
        SummonerName: String,
        APIKey: String
    ): Single<SummonerResponse> {
        return apiService.getSummonerInfoByName(SummonerName, APIKey)
    }

    override fun getSummonerEntriesByEncryptedSummonerID(
        encryptedSummonerId: String,
        APIKey: String
    ): Single<List<LeagueEntryResponse>> {
        return apiService.getSummonerEntriesByEncryptedSummonerID(encryptedSummonerId, APIKey)
    }

    override fun getLeagueByGivenID(leagueID: String, APIKey: String): Single<LeagueListResponse> {
        return apiService.getLeagueByGivenID(leagueID, APIKey)
    }

    override fun getMatchIdBypuuid(
        puuid: String,
        start: Int,
        count: Int,
        APIKey: String
    ): Single<List<String>> {
        return matchService.getMatchIdBypuuid(puuid, start, count, APIKey)
    }

    override fun getMatchInfoByMatchID(MatchId: String, APIKey: String): Single<MatchResponse> {
        return matchService.getMatchInfoByMatchID(MatchId, APIKey)
    }
}