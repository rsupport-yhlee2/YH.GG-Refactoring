package com.example.yhgg_refactoring.data.response

import com.google.gson.annotations.SerializedName

data class MetadataResponse (
    @SerializedName("dataVersion") val dataVersion : String,
    @SerializedName("matchId") val matchId : String,
    @SerializedName("participants") val participants : List<String>
        )