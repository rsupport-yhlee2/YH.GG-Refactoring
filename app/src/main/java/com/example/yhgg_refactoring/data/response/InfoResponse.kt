package com.example.yhgg_refactoring.data.response

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("gameDuration") val gameDuration: Long,
    @SerializedName("gameMode") val gameMode: String,
    @SerializedName("gameType") val gameType: String,
    @SerializedName("queueId") val queueId: String,
    @SerializedName("participants") var participants: List<ParticipantResponse>,
    @SerializedName("gameEndTimestamp") val gameEndTimestamp: Long
)