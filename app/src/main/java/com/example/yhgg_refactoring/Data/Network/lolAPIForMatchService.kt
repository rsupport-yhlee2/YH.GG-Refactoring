package com.example.yhgg_refactoring.Data.Network

import com.example.yhgg_refactoring.data.response.MatchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface lolAPIForMatchService {

    //매치정보를 불러오는 함수들은 LOLAPIForMatch를 사용하여 호출
    @GET("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    fun getMatchIdBypuuid(
        @Path("puuid") puuid: String,
        @Query("start") start: Int,
        @Query("count") count: Int,
        @Query("api_key") APIKey: String,
    ): Single<List<String>>

    //매치 아이디를 통해 매치 상세정보를 불러오는 함수
    @GET("/lol/match/v5/matches/{matchId}")
    fun getMatchInfoByMatchID(
        @Path("matchId") MatchId: String,
        @Query("api_key") APIKey: String
    ): Single<MatchResponse>
}