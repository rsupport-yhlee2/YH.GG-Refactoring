package com.example.yhgg_refactoring.data.response

import com.google.gson.annotations.SerializedName

data class LeagueListResponse(
    @SerializedName("leagueId") val leagueID : String,
    @SerializedName("entries") val entries : List<LeagueItemResponse>,
    @SerializedName("tier") val tier : String,
    @SerializedName("name") val name : String,
    @SerializedName("queue") val queue : String,
)
