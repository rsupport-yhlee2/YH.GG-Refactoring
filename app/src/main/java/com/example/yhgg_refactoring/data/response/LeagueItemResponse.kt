package com.example.yhgg_refactoring.data.response

import com.google.gson.annotations.SerializedName

data class LeagueItemResponse(
    @SerializedName("summonerName") val summonerName : String?,

    @SerializedName("miniSeries") val miniSeries : MiniSeriesResponse,

    @SerializedName("hotStreak") val hotStreak : Boolean?,
    @SerializedName("veteran") val veteran : Boolean?,
    @SerializedName("inactive") val inactive : Boolean?,
    @SerializedName("freshBlood") val freshBlood: Boolean,

    @SerializedName("rank") val rank : String?,
    @SerializedName("leaguePoints") val leaguePoints : Int?,

    @SerializedName("wins") val wins: Int,
    @SerializedName("losses") val losses : Int?,

    @SerializedName("summonerId") val summonerId : String?,
)